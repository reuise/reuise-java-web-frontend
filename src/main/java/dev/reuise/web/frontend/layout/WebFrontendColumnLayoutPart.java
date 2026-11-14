package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebColumnLayoutPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendColumnLayoutPart extends WebFrontendComponentPart , WebFrontendFlexContainerPart , WebFrontendColumnLayoutFeatures , WebColumnLayoutPart {
    WebFrontendFlexContainerPart getFlexContainerPart();
}
