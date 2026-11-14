package dev.reuise.web.frontend.navigation;
import dev.reuise.web.core.navigation.WebNavigationTreeLinkPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.link.WebFrontendNavigationLinkPart;
import dev.reuise.web.frontend.list.WebFrontendListItem;
public interface WebFrontendNavigationTreeLinkPart extends WebFrontendComponentPart , WebNavigationTreeLinkPart , WebFrontendNavigationTreeLinkFeatures , WebFrontendNavigationLinkPart {
    WebFrontendListItem getItem();

    WebFrontendNavigationLinkPart getNavigationLinkPart();
}
