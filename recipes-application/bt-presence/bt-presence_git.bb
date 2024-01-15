# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# about how to setup ssh-agent for passwordless access
SRC_URI = "files:///home/eboccati/coursera/linux-embedded/final-project/bt-human-presence"
# SRCREV = "a622968087b6fbbf0a3df1532d64cc5323d33782"
# SRC_URI[sha256sum] = "7766c49947c6574c8fb35d0dfcd795ada1e4e457ab5b15499d7000909b8e46e9"

PV = "1.0+git${SRCPV}"

# RDPENDS:${PN} = "libgcc"
# This sets your staging directory based on WORKDIR, where WORKDIR is defined at 
# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-WORKDIR
# We reference the "server" directory here to build from the "server" directory
# in your assignments repo
S = "${WORKDIR}/git"

# TODO: Add the aesdsocket application and any other files you need to install
# See https://git.yoctoproject.org/poky/plain/meta/conf/bitbake.conf?h=kirkstone
FILES:${PN} += " \
	${bindir}/bt-presence \
	"

# TODO: customize these as necessary for any libraries you need for your application
# (and remove comment)
# TARGET_LDFLAGS += "-pthread -lrt"

# inherit update-rc.d
# INITSCRIPT_NAME = "aesdsocket-start-stop"
# INITSCRIPT_PARAMS = " start 99 5 . stop 20 0 1 6 ."

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	# Be sure to install the target directory with install -d first
	# Yocto variables ${D} and ${S} are useful here, which you can read about at 
	# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-D
	# and
	# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-S
	# See example at https://github.com/cu-ecen-aeld/ecen5013-yocto/blob/ecen5013-hello-world/meta-ecen5013/recipes-ecen5013/ecen5013-hello-world/ecen5013-hello-world_git.bb
	install -d ${D}${bindir}
	install -m 0755 ${S}/bt-presence ${D}${bindir}

	# install -d ${D}/etc/init.d
	# install -m 0755 ${S}/aesdsocket-start-stop ${D}/etc/init.d/
}
