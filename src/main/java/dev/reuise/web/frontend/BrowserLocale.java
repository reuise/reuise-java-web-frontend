package dev.reuise.web.frontend;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Best-guess region of the current user, derived from the browser's language settings. This is
 * an inference (for example plain "en" resolves to "US"), not the user's physical location.
 */
public final class BrowserLocale {
    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "navigator")
    private static class JsNavigator {
        public static String language;
        public static String[] languages;
    }

    @JsType(isNative = true, namespace = "Intl", name = "Locale")
    private static class JsIntlLocale {
        public String region;

        public JsIntlLocale(String tag) {
        }

        public native JsIntlLocale maximize();
    }

    private BrowserLocale() {
    }

    /** Returns an upper-case ISO 3166-1 alpha-2 code, or null when it cannot be determined. */
    public static String getRegion() {
        try {
            String[] languages = JsNavigator.languages;
            if (languages != null) {
                for (String tag : languages) {
                    String region = regionOf(tag);
                    if (region != null) return region;
                }
            }

            String language = JsNavigator.language;
            String region = regionOf(language);
            if (region != null) return region;

            return inferRegion(language);
        } catch (Throwable t) {
            return null;
        }
    }

    private static String regionOf(String tag) {
        if (tag == null) return null;
        String[] parts = tag.split("[-_]");
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.length() == 2 && Character.isLetter(part.charAt(0)) && Character.isLetter(part.charAt(1))) {
                return part.toUpperCase();
            }
        }
        return null;
    }

    private static String inferRegion(String tag) {
        if (tag == null || tag.isEmpty()) return null;
        try {
            String region = new JsIntlLocale(tag).maximize().region;
            return region == null || region.isEmpty() ? null : region.toUpperCase();
        } catch (Throwable t) {
            return null;
        }
    }
}
