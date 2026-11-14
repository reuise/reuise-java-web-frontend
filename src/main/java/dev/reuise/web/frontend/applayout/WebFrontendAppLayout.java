package dev.reuise.web.frontend.applayout;
import dev.reuise.web.core.applayout.WebAppLayout;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendAppLayout extends WebFrontendAppLayoutPart , WebAppLayout , WebFrontendParentComponent , WebFrontendComponent {
    WebFrontendAppLayout getComponent();
}
