package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableFooterPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableFooterPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTableFooterPart , WebFrontendTableFooterFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
