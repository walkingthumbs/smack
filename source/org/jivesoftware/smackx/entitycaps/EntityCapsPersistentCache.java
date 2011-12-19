package org.jivesoftware.smackx.entitycaps;

import org.jivesoftware.smackx.packet.DiscoverInfo;

public interface EntityCapsPersistentCache {
	abstract void addDiscoverInfoByNodePersistent(String node, DiscoverInfo info);
	abstract void replay();
}
