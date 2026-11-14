package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableBody;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableBody extends WebFrontendParentComponent , WebTableBody , WebFrontendTableBodyPart , WebFrontendComponent {
    WebFrontendTableBody getComponent();
}
