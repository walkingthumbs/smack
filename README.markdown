About
=====
This repository contains an extended version of [Smack](http://www.igniterealtime.org/projects/smack/). It's primary used by [aSmack](https://github.com/Flowdalic/asmack), to build an Android version of Smack. But since aSmack just changes some stuff and adds patches on top of a Smack branch, these branches can be used also in non-Android environments.

Branches
========

- master
- xep0198
- upstream
- smack-aiv smack from [a-iv](https://github.com/a-iv), who contributed here too.
- dnssec (DNSSEC patches on top of master)
- maybe some other branches to test new patches

master
--------------
The current state of Smack trunk, plus additional patches.

### Additional non-upstream (yet) patches
Here's a list of patches that are included in master. If there is a issue on the offical smack bugtracker, it will be linked too. The issue reports usually contain also a link to Smack's community forums, where more information about the issue can be found.

- [Roster Versioning XEP-0237](http://xmpp.org/extensions/xep-0237.html) [SMACK-399](http://issues.igniterealtime.org/browse/SMACK-399)
- BOSH support (XMPP over HTTP aka. HTTP Binding) [SMACK-187](http://issues.igniterealtime.org/browse/SMACK-187)
- Fix for [SMACK-384 Endless waiting for connection to be established](http://issues.igniterealtime.org/browse/SMACK-384)
- Maybe some more fixes I can't remeber right now.

xep0198
----------------------
In sync with master plus XEP-0198 patches from devrandom (gibberbot)

upstream
--------
The current state of the vanilla SMACK (upstream) development.

dnssec
------
DNSSEC patches from Adam Fisk. Logged as [SMACK-366](http://issues.igniterealtime.org/browse/SMACK-366). Forum Link: http://community.igniterealtime.org/message/220886#220886

Contributing
============
Please follow the guidelines for Smack contributors: http://community.igniterealtime.org/docs/DOC-1984

History
=======
This fork of smack was initiated by Rene Treffer for the [aSmack build environment](http://code.google.com/p/asmack/), in order to get Smack working on Android for the [buddycloud project](https://buddycloud.org/). aSmack on Googlecode is now inactive. Before the project was abdoned, Rene migrated the data from Googlecode to GitHub. This is where I forked his repo and started working on aSmack, mostly janitorial tasks, but I also merged smack 3.2.0 and keep master in sync with upstream.

Contact
=======
Join ##smack @ freenode

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
