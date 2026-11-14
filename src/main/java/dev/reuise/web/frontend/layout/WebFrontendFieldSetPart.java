package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebFieldSetPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendFieldSetPart extends WebFrontendComponentPart , WebFrontendFieldSetFeatures , WebFrontendContainerPart , WebFieldSetPart {
    WebFrontendContainerPart getContainerPart();
}
