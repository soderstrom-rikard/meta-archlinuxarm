DESCRIPTION = "AsciiDoc is a text document format for writing short documents, \
articles, books and UNIX man pages."

HOMEPAGE = "http://www.methods.co.nz/asciidoc/"
LICENSE = "GPLv2"

SRC_URI = " http://downloads.sourceforge.net/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"

inherit distutils-base autotools-brokensep

export DESTDIR = "${D}"

FILES_${PN} += "${sysconfdir}"

RDEPENDS_${PN} += "python"

SRC_URI[md5sum] = "c59018f105be8d022714b826b0be130a"
SRC_URI[sha256sum] = "78db9d0567c8ab6570a6eff7ffdf84eadd91f2dfc0a92a2d0105d323cab4e1f0"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=029ad5428ba5efa20176b396222d4069"

BBCLASSEXTEND = "native"
