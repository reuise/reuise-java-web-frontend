package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTablePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTablePart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendTableFeatures , WebTablePart {
    boolean isScrollEnd();

    WebFrontendContainer getTable();

    WebFrontendTableColumnGroup getColumnGroup();

    WebFrontendTableHeader getHeader();

    WebFrontendTableBody getBody();

    WebFrontendTableFooter getFooter();

    WebFrontendParentComponentPart getParentComponentPart();
}
