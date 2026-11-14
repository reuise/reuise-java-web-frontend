package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeaderRow;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableHeaderRow extends WebFrontendParentComponent , WebTableHeaderRow , WebFrontendTableHeaderRowPart , WebFrontendComponent {
    WebFrontendTableHeaderRow getComponent();
}
