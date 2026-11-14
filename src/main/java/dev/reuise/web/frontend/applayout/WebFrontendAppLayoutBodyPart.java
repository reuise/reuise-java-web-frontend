package dev.reuise.web.frontend.applayout;
import dev.reuise.web.core.applayout.WebAppLayoutBodyPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
public interface WebFrontendAppLayoutBodyPart extends WebFrontendComponentPart , WebFrontendFlexContainerPart , WebFrontendAppLayoutBodyFeatures , WebAppLayoutBodyPart {
    WebFrontendFlexContainerPart getFlexContainerPart();
}
