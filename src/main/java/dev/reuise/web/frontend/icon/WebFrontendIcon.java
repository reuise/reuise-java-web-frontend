package dev.reuise.web.frontend.icon;
import dev.reuise.web.core.icon.WebIcon;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendIcon extends WebIcon , WebFrontendParentComponent , WebFrontendComponent , WebFrontendIconPart {
    WebFrontendIcon getComponent();
}
