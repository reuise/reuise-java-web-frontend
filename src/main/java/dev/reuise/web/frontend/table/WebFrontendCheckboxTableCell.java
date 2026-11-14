package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebCheckboxTableCell;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendCheckboxTableCell extends WebFrontendCheckboxTableCellPart , WebFrontendTableCell , WebFrontendComponent , WebCheckboxTableCell {
    WebFrontendCheckboxTableCell getComponent();
}
