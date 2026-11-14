package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeaderPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableHeaderPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendTableHeaderFeatures , WebTableHeaderPart {
    WebFrontendTableHeaderRow getRow();

    WebFrontendParentComponentPart getParentComponentPart();
}
