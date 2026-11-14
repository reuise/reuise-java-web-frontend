package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeaderCellOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendTableHeaderCellOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebTableHeaderCellOptions , WebFrontendBaseComponentPartOptions , WebFrontendTableHeaderCellPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
