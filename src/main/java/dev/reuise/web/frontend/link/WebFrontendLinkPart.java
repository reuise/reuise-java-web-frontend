package dev.reuise.web.frontend.link;
import dev.reuise.web.core.link.WebLinkPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendLinkPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebLinkPart , WebFrontendLinkFeatures {
    WebFrontendIcon getStartIcon();

    WebFrontendIcon getEndIcon();

    WebFrontendParentComponentPart getParentComponentPart();
}
