package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebSheetLayoutOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerOptions;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSheetLayoutOptions extends WebSheetLayoutOptions , WebFrontendComponentOptions , WebFrontendSplitContainerOptions , WebFrontendBaseComponentPartOptions , WebFrontendSplitContainerPartOptions , WebFrontendSheetLayoutPartOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendSplitContainerPartOptions getSplitContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
