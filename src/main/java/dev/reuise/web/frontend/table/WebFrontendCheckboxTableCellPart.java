package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebCheckboxTableCellPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
public interface WebFrontendCheckboxTableCellPart extends WebFrontendCheckboxTableCellFeatures , WebFrontendTableCellPart , WebFrontendComponentPart , WebCheckboxTableCellPart {
    WebFrontendCheckbox getCheckbox();

    WebFrontendTableCellPart getTableCellPart();
}
