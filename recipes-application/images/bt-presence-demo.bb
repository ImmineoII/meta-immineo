include recipes-core/images/core-image-base.bb

IMAGE_INSTALL:append ="\
    packagegroup-base-bluetooth \
    bluez5 \
    bt-presence \
    "