package dev.reuise.web.frontend;

import akasha.PopStateEvent;
import akasha.PopStateEventInit;
import akasha.WindowGlobal;

public class Navigator {
    public static void updateUrl(String url) {
        if (url == null || url.isEmpty())
            return;

        WindowGlobal.history().pushState(null, "", url);
        WindowGlobal.dispatchEvent(new PopStateEvent("popstate", PopStateEventInit.of()
                .bubbles(false)
                .cancelable(false)));
    }

}
