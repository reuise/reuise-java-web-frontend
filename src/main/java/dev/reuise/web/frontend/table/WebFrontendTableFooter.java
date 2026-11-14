package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableFooter;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTableFooter extends WebFrontendParentComponent , WebFrontendTableFooterPart , WebTableFooter , WebFrontendComponent {
    WebFrontendTableFooter getComponent();
}
