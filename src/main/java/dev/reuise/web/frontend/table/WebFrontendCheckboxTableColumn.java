package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebCheckboxTableColumn;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendCheckboxTableColumn extends WebFrontendTableColumn , WebFrontendCheckboxTableColumnPart , WebFrontendComponent , WebCheckboxTableColumn {
    WebFrontendCheckboxTableColumn getComponent();
}
