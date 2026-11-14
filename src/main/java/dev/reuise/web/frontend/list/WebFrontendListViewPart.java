package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebListViewPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendListViewPart extends WebListViewPart , WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendListViewFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
