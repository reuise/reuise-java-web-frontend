package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebBasicListPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendBasicListPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebBasicListPart , WebFrontendBasicListFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
