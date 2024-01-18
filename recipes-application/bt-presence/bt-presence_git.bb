# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=36565ba12654baa7586a38991e331be6"

SRC_URI = "git://github.com/ImmineoII/bt-human-presence.git;protocol=https;branch=main;"
SRCREV = "a296d92db4393d128a17f0359789394de4af5873"
SRC_URI[sha256sum] = "7766c49947c6574c8fb35d0dfcd795ada1e4e457ab5b15499d7000909b8e46e9"

DEPENDS = "bluez5"

S = "${WORKDIR}/git"

FILES:${PN} += " \
	${bindir}/bt-presence \
	"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/bt-presence ${D}${bindir}
}
