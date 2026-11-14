package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebCheckboxTableColumnOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendCheckboxTableColumnOptions extends WebFrontendComponentOptions , WebCheckboxTableColumnOptions , WebFrontendCheckboxTableColumnPartOptions , WebFrontendTableColumnOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions , WebFrontendTableColumnPartOptions {
    WebFrontendTableColumnPartOptions getTableColumnPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
