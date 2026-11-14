package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTable;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTable extends WebFrontendParentComponent , WebTable , WebFrontendTablePart , WebFrontendComponent {
    WebFrontendTable getComponent();
}
