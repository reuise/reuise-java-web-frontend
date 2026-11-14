package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeaderOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendTableHeaderOptions extends WebFrontendParentComponentOptions , WebTableHeaderOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendTableHeaderPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
