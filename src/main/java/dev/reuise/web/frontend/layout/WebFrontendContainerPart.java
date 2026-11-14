package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebContainerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendContainerPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebContainerPart , WebFrontendContainerFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
