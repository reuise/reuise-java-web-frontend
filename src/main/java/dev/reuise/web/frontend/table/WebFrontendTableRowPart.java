package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableRowPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableRowPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTableRowPart , WebFrontendTableRowFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
