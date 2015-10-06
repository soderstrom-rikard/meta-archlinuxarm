DESCRIPTION="Development build of pacman"

inherit autotools gettext

#require 
DEPENDS += "openssl libarchive asciidoc"
RDEPENDS += "asciidoc"

LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "\
file://COPYING;md5=751419260aa954499f7abaabaa882bbe \
"

SRC_URI      = "git://projects.archlinux.org/pacman.git;protocol=git;branch=master"
SRCREV       = "578035075108a90d20f084f077badf05d1c8527c"
S            = "${WORKDIR}/git"
EXTRA_OECONF = ""

do_configure_prepend() {
  cd ${WORKDIR}/git
  git clean -fdx
  ./autogen.sh
  cd -
}
