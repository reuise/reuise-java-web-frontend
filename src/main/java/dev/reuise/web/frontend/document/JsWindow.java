package dev.reuise.web.frontend.document;

import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import jsinterop.annotations.JsPackage;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "window")
public class JsWindow {
    public static JsPropertyMap<Object> reuiseDocModel;
    public static String reuiseViewId;
}