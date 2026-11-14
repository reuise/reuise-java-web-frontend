package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeaderCell;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableHeaderCell extends WebFrontendParentComponent , WebFrontendTableHeaderCellPart , WebTableHeaderCell , WebFrontendComponent {
    WebFrontendTableHeaderCell getComponent();
}
