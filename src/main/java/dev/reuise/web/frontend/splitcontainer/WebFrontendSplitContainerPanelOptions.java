package dev.reuise.web.frontend.splitcontainer;
import dev.reuise.web.core.splitcontainer.WebSplitContainerPanelOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSplitContainerPanelOptions extends WebFrontendContainerOptions , WebSplitContainerPanelOptions , WebFrontendComponentOptions , WebFrontendSplitContainerPanelPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
