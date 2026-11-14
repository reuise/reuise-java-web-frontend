package dev.reuise.web.frontend.view;
import dev.reuise.web.core.view.WebSheetViewOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSheetViewOptions extends WebFrontendComponentOptions , WebFrontendViewPartOptions , WebSheetViewOptions , WebFrontendBaseComponentPartOptions , WebFrontendFlexContainerPartOptions , WebFrontendContainerPartOptions , WebFrontendSheetViewPartOptions , WebFrontendParentComponentPartOptions , WebFrontendViewOptions {
    WebFrontendViewPartOptions getViewPart();

    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    WebFrontendContainerPartOptions getContainerPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
