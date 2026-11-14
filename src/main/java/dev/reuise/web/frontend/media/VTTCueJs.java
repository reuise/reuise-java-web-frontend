package dev.reuise.web.frontend.media;

import jsinterop.annotations.JsType;

import javax.annotation.Nonnull;

import jsinterop.annotations.JsPackage;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "VTTCue")
public class VTTCueJs extends akasha.VTTCue {
    public VTTCueJs(final double startTime, final double endTime, @Nonnull final String text) {
        super(startTime, endTime, text);
    }
}