package dev.reuise.web.frontend.tabs;
import dev.reuise.web.core.tabs.WebTabBarOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendTabBarOptions extends WebFrontendContainerOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebTabBarOptions , WebFrontendContainerPartOptions , WebFrontendTabBarPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
