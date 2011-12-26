package org.jivesoftware.smackx.entitycaps;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.Base64;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.packet.DiscoverInfo;
import org.xmlpull.mxp1.MXParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SimpleDirectoryPersistentCache implements
		EntityCapsPersistentCache {
	
	private File cacheDir;
	
	public SimpleDirectoryPersistentCache(File cacheDir) {
		if (!cacheDir.exists()) 
			throw new IllegalStateException("Cache directory \"" + cacheDir + "\" does not exist");
		if (!cacheDir.isDirectory())
			throw new IllegalStateException("Cache directory \"" + cacheDir + "\" is not a directory");

		this.cacheDir = cacheDir;		
	}

	@Override
	public void addDiscoverInfoByNodePersistent(String node, DiscoverInfo info) {
	    String base64Node = Base64.encodeBytes(node.getBytes());
		File nodeFile = new File(cacheDir, base64Node);
		
		try {
			if (nodeFile.createNewFile())
				writeInfoToFile(nodeFile, info);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	@Override
	public void replay() {
	    File[] files = cacheDir.listFiles();
		for (File f : files) {
			String nodeBase64 = f.getName();
			String node = new String(Base64.decode(nodeBase64));
			DiscoverInfo info;
			try {
				info = restoreInfoFromFile(f);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			if (info == null)
				continue;
			
			EntityCapsManager.addDiscoverInfoByNode(node, info);
		}
	}
	
    public void emptyCache() {
        File[] files = cacheDir.listFiles();
        for (File f : files) {
            f.delete();
        }
    }
	
	private static void writeInfoToFile(File file, DiscoverInfo info) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeUTF(info.toXML());
	}
	
    private static DiscoverInfo restoreInfoFromFile(File file) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        String fileContent = dis.readUTF();
        Reader reader = new StringReader(fileContent);
        XmlPullParser parser;
        try {
            parser = new MXParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            parser.setInput(reader);
        } catch (XmlPullParserException xppe) {
            xppe.printStackTrace();
            return null;
        }

        DiscoverInfo iqPacket;
        IQProvider provider = (IQProvider) ProviderManager.getInstance().getIQProvider("query", "http://jabber.org/protocol/disco#info");
        
        // skip the first <iq id=....> tag
        try {
            parser.next();
        } catch (XmlPullParserException e1) {
            e1.printStackTrace();
            return null;
        }

        // Point parser to the query tag
        try {
            parser.next();
        } catch (XmlPullParserException e1) {
            e1.printStackTrace();
            return null;
        }
        
        try {
            iqPacket = (DiscoverInfo) provider.parseIQ(parser);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return iqPacket;
    }
}
