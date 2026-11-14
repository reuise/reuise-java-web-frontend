package dev.reuise.web.frontend.navigation;
import dev.reuise.web.core.navigation.WebNavigationTreeLink;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.link.WebFrontendNavigationLink;
public interface WebFrontendNavigationTreeLink extends WebFrontendNavigationLink , WebFrontendComponent , WebFrontendNavigationTreeLinkPart , WebNavigationTreeLink {
    WebFrontendNavigationTreeLink getComponent();
}
