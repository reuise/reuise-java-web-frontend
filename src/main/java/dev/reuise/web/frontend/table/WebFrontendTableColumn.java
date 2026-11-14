package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableColumn;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableColumn extends WebFrontendParentComponent , WebTableColumn , WebFrontendComponent , WebFrontendTableColumnPart {
    WebFrontendTableColumn getComponent();
}
