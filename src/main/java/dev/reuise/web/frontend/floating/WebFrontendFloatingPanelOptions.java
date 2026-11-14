package dev.reuise.web.frontend.floating;
import dev.reuise.web.core.floating.WebFloatingPanelOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendFloatingPanelOptions extends WebFrontendContainerOptions , WebFrontendComponentOptions , WebFrontendFloatingPanelPartOptions , WebFrontendBaseComponentPartOptions , WebFloatingPanelOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
