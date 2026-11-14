package dev.reuise.web.frontend.tabs;
import dev.reuise.web.core.tabs.WebTabBarPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendTabBarPart extends WebTabBarPart , WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendTabBarFeatures {
    WebFrontendContainer getContainer();

    WebFrontendContainer getActiveIndicator();

    WebFrontendContainerPart getContainerPart();
}
