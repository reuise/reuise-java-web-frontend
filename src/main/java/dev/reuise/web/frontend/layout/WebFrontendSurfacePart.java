package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebSurfacePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSurfacePart extends WebFrontendComponentPart , WebSurfacePart , WebFrontendSurfaceFeatures , WebFrontendFlexContainerPart {
    WebFrontendFlexContainerPart getFlexContainerPart();
}
