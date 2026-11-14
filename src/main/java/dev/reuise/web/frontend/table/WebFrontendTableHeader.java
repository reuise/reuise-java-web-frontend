package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeader;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableHeader extends WebFrontendParentComponent , WebTableHeader , WebFrontendTableHeaderPart , WebFrontendComponent {
    WebFrontendTableHeader getComponent();
}
