package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableColumnGroup;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableColumnGroup extends WebFrontendTableColumnGroupPart , WebFrontendParentComponent , WebTableColumnGroup , WebFrontendComponent {
    WebFrontendTableColumnGroup getComponent();
}
