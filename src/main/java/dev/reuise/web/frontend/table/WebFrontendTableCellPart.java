package dev.reuise.web.frontend.table;
import dev.reuise.web.core.table.WebTableCellPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendTableCellPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendTableCellFeatures , WebTableCellPart {
    WebFrontendParentComponentPart getParentComponentPart();
}
