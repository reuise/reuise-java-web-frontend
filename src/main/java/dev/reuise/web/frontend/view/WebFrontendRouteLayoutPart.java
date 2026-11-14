package dev.reuise.web.frontend.view;
import dev.reuise.web.core.view.WebRouteLayoutPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendRouteLayoutPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendRouteLayoutFeatures , WebRouteLayoutPart {
    WebFrontendContainerPart getContainerPart();
}
