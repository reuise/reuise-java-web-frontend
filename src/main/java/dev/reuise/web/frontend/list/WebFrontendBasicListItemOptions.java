package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebBasicListItemOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendBasicListItemOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendBasicListItemPartOptions , WebFrontendBaseComponentPartOptions , WebBasicListItemOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
