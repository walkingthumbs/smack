About
=====
This repository contains an extended version of [Smack](http://www.igniterealtime.org/projects/smack/). It's primary used by [aSmack](https://github.com/Flowdalic/asmack), to build an Android version of Smack. But since aSmack just changes some stuff and adds patches on top of a Smack branch, these branches can be used also in non-Android environments.

Branches
========

- smack_extended
- smack_extended_xep0198
- upstream
- caps
- smack-aiv smack from [a-iv](https://github.com/a-iv), who contributed here too.
- dnssec_extended (DNSSEC patches on top of smack_extended)
- maybe some other branches to test new patches

smack_extended
--------------
The current state of Smack, plus additional patches.

### Additional non-upstream (yet) patches
Here's a list of patches that are included in smack_extended. If there is a issue on the offical smack bugtracker, it will be linked too. The issue reports usually contain also a link to Smack's community forums, where more information about the issue can be found.

- Fix for [SMACK-278 Deadlock during Smack disconnect](http://issues.igniterealtime.org/browse/SMACK-278)
- Fix for [SMACK-371](http://issues.igniterealtime.org/browse/SMACK-371) Update MUC to the current spec (Prospody MUC support)
- Entity Capabilites support [SMACK-361](http://issues.igniterealtime.org/browse/SMACK-361)
- [Roster Versioning XEP-0237](http://xmpp.org/extensions/xep-0237.html)
- BOSH support (XMPP over HTTP aka. HTTP Binding) [SMACK-187](http://issues.igniterealtime.org/browse/SMACK-187)
- Some more fixes I can't remeber atm

smack_extended_xep0198
----------------------
In sync with smack_extended plus XEP-0198 patches from devrandom (gibberbot)

upstream
--------
The current state of the vanilla SMACK (upstream) development.

caps
----
An Entity Capsabilities implementation on top of vanilla smack. Similar to the one found in smack_extended. Test cases are missing and are maybe the only reason this hasn't gone upstream yet.

History
=======
This fork of smack was initiated by Rene Treffer for the [aSmack build environment](http://code.google.com/p/asmack/), in order to get Smack working on Android for the [buddycloud project](https://buddycloud.org/). aSmack on Googlecode is now inactive. Before the project was abdoned, Rene migrated the data from Googlecode to GitHub. This is where I forked his repo and started working on aSmack, mostly janitorial tasks, but I also merged smack 3.2.0 and keep smack_extended in sync with upstream.

Contact
=======
Join us: ##smack @ freenode

Kudos
=====

Goes to

- Rene Treffer
- Till Glocke
- a-iv
- Jonas Ådahl

Licenses
=======

- Smack (Apache License)
- DNSSEC4J (Apache License and GPLv3)