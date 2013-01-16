.PHONY: all clean
.INTERMEDIATE: .settings

all: build-smack .settings

.settings:
	ln -s build/eclipse/.settings .settings
	ln -s build/eclipse/.classpath .classpath
	ln -s build/eclipse/.project .project

# Can not use 'build' as target name, because there is a
# directory called build
build-smack:
	cd build && ant

clean:
	cd build && ant clean

test-unit:
	cd build && ant test-unit
