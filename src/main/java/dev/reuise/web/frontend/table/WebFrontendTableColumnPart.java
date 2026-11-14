package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableColumnPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableColumnPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTableColumnPart , WebFrontendTableColumnFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
