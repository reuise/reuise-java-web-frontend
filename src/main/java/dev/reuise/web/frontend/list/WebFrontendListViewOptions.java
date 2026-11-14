package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebListViewOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendListViewOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebListViewOptions , WebFrontendBaseComponentPartOptions , WebFrontendListViewPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
