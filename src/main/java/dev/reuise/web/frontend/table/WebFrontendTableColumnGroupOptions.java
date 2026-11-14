package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableColumnGroupOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendTableColumnGroupOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendTableColumnGroupPartOptions , WebFrontendBaseComponentPartOptions , WebTableColumnGroupOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
