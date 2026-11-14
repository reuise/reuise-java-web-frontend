package dev.reuise.web.frontend.link;
import dev.reuise.web.core.link.WebLink;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendLink extends WebLink , WebFrontendParentComponent , WebFrontendLinkPart , WebFrontendComponent {
    WebFrontendLink getComponent();
}
