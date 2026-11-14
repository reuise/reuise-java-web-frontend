package dev.reuise.web.frontend.drawer;
import dev.reuise.web.core.drawer.WebDrawerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendDrawerPart extends WebFrontendDrawerFeatures , WebFrontendComponentPart , WebDrawerPart , WebFrontendContainerPart {
    WebFrontendContainerPart getContainerPart();
}
