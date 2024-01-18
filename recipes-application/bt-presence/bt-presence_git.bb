# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git:///home/eboccati/coursera/linux-embedded/final-project/bt-human-presence/;protocol=file;branch=main;"
SRCREV = "a296d92db4393d128a17f0359789394de4af5873"
SRC_URI[sha256sum] = "7766c49947c6574c8fb35d0dfcd795ada1e4e457ab5b15499d7000909b8e46e9"

PV = "1.0+git${SRCPV}"

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
