package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerScrollAreaPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendScrollableContainerScrollAreaPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebScrollableContainerScrollAreaPart , WebFrontendScrollableContainerScrollAreaFeatures {
    WebFrontendContainer getScrollAreaTopFade();

    WebFrontendContainer getScrollAreaLeftFade();

    WebFrontendContainer getScrollAreaContent();

    WebFrontendContainer getScrollAreaBottomFade();

    WebFrontendContainer getScrollAreaRightFade();

    WebFrontendParentComponentPart getParentComponentPart();
}
