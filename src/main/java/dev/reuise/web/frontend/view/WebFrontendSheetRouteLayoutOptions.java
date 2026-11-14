package dev.reuise.web.frontend.view;
import dev.reuise.web.core.view.WebSheetRouteLayoutOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayoutOptions;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayoutPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSheetRouteLayoutOptions extends WebFrontendSheetLayoutOptions , WebFrontendSheetRouteLayoutPartOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendSplitContainerPartOptions , WebFrontendSheetLayoutPartOptions , WebSheetRouteLayoutOptions , WebFrontendContainerPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendSheetLayoutPartOptions getSheetLayoutPart();

    WebFrontendSplitContainerPartOptions getSplitContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
