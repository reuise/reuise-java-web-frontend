package dev.reuise.web.frontend.view;
import akasha.TimerHandler;
import dev.reuise.web.core.view.WebViewPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
public interface WebFrontendViewPart extends WebFrontendComponentPart , WebFrontendViewFeatures , WebFrontendFlexContainerPart , WebViewPart {
    int setTimeout(TimerHandler handler, int timeout);

    int setInterval(TimerHandler handler, int timeout);

    WebFrontendViewPart setDocumentTitle(String title);

    String getDocumentTitle();

    WebFrontendFlexContainerPart getFlexContainerPart();
}
