package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableBodyPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableBodyPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebTableBodyPart , WebFrontendTableBodyFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
