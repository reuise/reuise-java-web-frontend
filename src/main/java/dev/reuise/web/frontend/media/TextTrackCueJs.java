package dev.reuise.web.frontend.media;

import jsinterop.annotations.JsType;
import jsinterop.annotations.JsPackage;

@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "TextTrack"
)
public  class TextTrackCueJs extends akasha.TextTrackCue {
}