package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebCheckboxTableColumnPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
// Checked here??
public interface WebFrontendCheckboxTableColumnPart extends WebFrontendComponentPart , WebCheckboxTableColumnPart , WebFrontendCheckboxTableColumnFeatures , WebFrontendTableColumnPart {
    boolean isChecked();

    WebFrontendCheckboxTableColumnPart setChecked(Boolean checked);

    WebFrontendCheckbox getCheckbox();

    WebFrontendTableColumnPart getTableColumnPart();
}
