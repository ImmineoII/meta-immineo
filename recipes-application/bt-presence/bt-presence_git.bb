# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=36565ba12654baa7586a38991e331be6"

FILESEXTRAPATHs:prepend := "${THISDIR}${PN}:"

SRC_URI = "\
	git://github.com/ImmineoII/bt-human-presence.git;protocol=https;branch=main; \
	file://bt-presence.service \
	file://.config \
	"

SRCREV = "4a0d49970bc30b63ecb2646fd3f2b7ebb8268d05"
SRC_URI[sha256sum] = "7766c49947c6574c8fb35d0dfcd795ada1e4e457ab5b15499d7000909b8e46e9"

DEPENDS = "bluez5"

S = "${WORKDIR}/git"

FILES:${PN} += " \
	${bindir}/bt-presence \
	${systemd_unitdir}/system/bt-presence.service \
	"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "bt-presence.service"

do_configure () {
	cp ${WORKDIR}/.config ${S}
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/bt-presence ${D}${bindir}

	install -d ${D}${systemd_unitdir}/system	
	install -m 0644 ${WORKDIR}/bt-presence.service ${D}${systemd_unitdir}/system
}
