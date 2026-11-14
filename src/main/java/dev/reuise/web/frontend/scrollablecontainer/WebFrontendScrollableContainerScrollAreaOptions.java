package dev.reuise.web.frontend.scrollablecontainer;
import dev.reuise.web.core.scrollablecontainer.WebScrollableContainerScrollAreaOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendScrollableContainerScrollAreaOptions extends WebFrontendScrollableContainerScrollAreaPartOptions , WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebScrollableContainerScrollAreaOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
