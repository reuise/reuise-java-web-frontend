package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableColumnGroupPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableColumnGroupPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendTableColumnGroupFeatures , WebTableColumnGroupPart {
    WebFrontendParentComponentPart getParentComponentPart();
}
