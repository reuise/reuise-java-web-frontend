package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableHeaderRowPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableHeaderRowPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendTableHeaderRowFeatures , WebTableHeaderRowPart {
    WebFrontendParentComponentPart getParentComponentPart();
}
