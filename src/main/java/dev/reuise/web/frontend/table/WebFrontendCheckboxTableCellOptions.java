package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebCheckboxTableCellOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendCheckboxTableCellOptions extends WebFrontendTableCellOptions , WebFrontendComponentOptions , WebFrontendCheckboxTableCellPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendTableCellPartOptions , WebFrontendParentComponentPartOptions , WebCheckboxTableCellOptions {
    WebFrontendTableCellPartOptions getTableCellPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
