package dev.reuise.web.frontend.link;
import dev.reuise.web.core.link.WebNavigationLinkPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendNavigationLinkPart extends WebFrontendComponentPart , WebFrontendNavigationLinkFeatures , WebFrontendLinkPart , WebNavigationLinkPart {
    WebFrontendLinkPart getLinkPart();
}
