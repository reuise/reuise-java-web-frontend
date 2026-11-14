package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableRow;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableRow extends WebFrontendTableRowPart , WebTableRow , WebFrontendParentComponent , WebFrontendComponent {
    WebFrontendTableRow getComponent();
}
