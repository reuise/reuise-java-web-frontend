package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebButtonBarPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
public interface WebFrontendButtonBarPart extends WebFrontendComponentPart , WebFrontendFlexContainerPart , WebButtonBarPart , WebFrontendButtonBarFeatures {
    WebFrontendFlexContainerPart getFlexContainerPart();
}
