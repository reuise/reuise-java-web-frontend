package dev.reuise.web.frontend.view;
import dev.reuise.web.core.view.WebViewFeatures;
public interface WebFrontendViewFeatures extends WebViewFeatures {
    String getUrl();

    WebFrontendViewFeatures setUrl(String url);
}
