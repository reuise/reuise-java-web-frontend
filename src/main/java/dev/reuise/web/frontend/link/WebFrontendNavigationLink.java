package dev.reuise.web.frontend.link;
import dev.reuise.web.core.link.WebNavigationLink;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendNavigationLink extends WebNavigationLink , WebFrontendLink , WebFrontendComponent , WebFrontendNavigationLinkPart {
    WebFrontendNavigationLink getComponent();
}
