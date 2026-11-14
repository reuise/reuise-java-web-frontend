package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableCell;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableCell extends WebFrontendTableCellPart , WebFrontendParentComponent , WebTableCell , WebFrontendComponent {
    WebFrontendTableCell getComponent();
}
