package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebListItemOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendListItemOptions extends WebFrontendBasicListItemOptions , WebFrontendComponentOptions , WebListItemOptions , WebFrontendBasicListItemPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendListItemPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendBasicListItemPartOptions getBasicListItemPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
