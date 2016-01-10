DESCRIPTION="Development build of pacman"

inherit autotools gettext

#require 
DEPENDS += "openssl libarchive asciidoc"
RDEPENDS_${PN} += "asciidoc perl bash"

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

SRC_URI += "\
  file://configure.ac.patch \
"

FILES_${PN} += "\
  /usr/share/makepkg \
  /usr/share/pacman \
  /usr/share/makepkg/lint_pkgbuild.sh \
  /usr/share/makepkg/tidy.sh \
  /usr/share/makepkg/source.sh \
  /usr/share/makepkg/lint_package.sh \
  /usr/share/makepkg/util.sh \
  /usr/share/makepkg/tidy \
  /usr/share/makepkg/source \
  /usr/share/makepkg/lint_pkgbuild \
  /usr/share/makepkg/lint_package \
  /usr/share/makepkg/util \
  /usr/share/makepkg/tidy/staticlibs.sh \
  /usr/share/makepkg/tidy/optipng.sh \
  /usr/share/makepkg/tidy/libtool.sh \
  /usr/share/makepkg/tidy/strip.sh \
  /usr/share/makepkg/tidy/upx.sh \
  /usr/share/makepkg/tidy/docs.sh \
  /usr/share/makepkg/tidy/zipman.sh \
  /usr/share/makepkg/tidy/purge.sh \
  /usr/share/makepkg/tidy/emptydirs.sh \
  /usr/share/makepkg/source/file.sh \
  /usr/share/makepkg/source/git.sh \
  /usr/share/makepkg/source/bzr.sh \
  /usr/share/makepkg/source/svn.sh \
  /usr/share/makepkg/source/local.sh \
  /usr/share/makepkg/source/hg.sh \
  /usr/share/makepkg/lint_pkgbuild/arch.sh \
  /usr/share/makepkg/lint_pkgbuild/provides.sh \
  /usr/share/makepkg/lint_pkgbuild/backup.sh \
  /usr/share/makepkg/lint_pkgbuild/optdepends.sh \
  /usr/share/makepkg/lint_pkgbuild/pkgbase.sh \
  /usr/share/makepkg/lint_pkgbuild/changelog.sh \
  /usr/share/makepkg/lint_pkgbuild/pkgver.sh \
  /usr/share/makepkg/lint_pkgbuild/pkgname.sh \
  /usr/share/makepkg/lint_pkgbuild/pkglist.sh \
  /usr/share/makepkg/lint_pkgbuild/source.sh \
  /usr/share/makepkg/lint_pkgbuild/pkgrel.sh \
  /usr/share/makepkg/lint_pkgbuild/package_function.sh \
  /usr/share/makepkg/lint_pkgbuild/util.sh \
  /usr/share/makepkg/lint_pkgbuild/epoch.sh \
  /usr/share/makepkg/lint_pkgbuild/install.sh \
  /usr/share/makepkg/lint_pkgbuild/options.sh \
  /usr/share/makepkg/lint_package/build_references.sh \
  /usr/share/makepkg/lint_package/missing_backup.sh \
  /usr/share/makepkg/util/option.sh \
  /usr/share/makepkg/util/source.sh \
  /usr/share/makepkg/util/util.sh \
  /usr/share/makepkg/util/pkgbuild.sh \
  /usr/share/makepkg/util/message.sh \
  /usr/share/pacman/PKGBUILD-vcs.proto \
  /usr/share/pacman/PKGBUILD-split.proto \
  /usr/share/pacman/PKGBUILD.proto \
  /usr/share/pacman/proto.install \
"
