package dev.reuise.web.frontend.divider;
import dev.reuise.web.core.divider.WebDivider;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendDivider extends WebFrontendParentComponent , WebDivider , WebFrontendComponent , WebFrontendDividerPart {
    WebFrontendDivider getComponent();
}
