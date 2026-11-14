package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebBasicListItemPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendBasicListItemPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebBasicListItemPart , WebFrontendBasicListItemFeatures {
    WebFrontendLink getLink();

    WebFrontendParentComponentPart getParentComponentPart();
}
