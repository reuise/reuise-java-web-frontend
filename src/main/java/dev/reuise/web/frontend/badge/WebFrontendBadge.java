package dev.reuise.web.frontend.badge;
import dev.reuise.web.core.badge.WebBadge;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendBadge extends WebFrontendBaseComponent , WebBadge , WebFrontendBadgePart , WebFrontendComponent {
    WebFrontendBadge getComponent();
}
