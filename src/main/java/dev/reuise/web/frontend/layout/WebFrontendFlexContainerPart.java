package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebFlexContainerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendFlexContainerPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendFlexContainerFeatures , WebFlexContainerPart {
    WebFrontendContainerPart getContainerPart();
}
