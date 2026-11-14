package dev.reuise.web.frontend.parentcomponent;
import dev.reuise.web.core.parentcomponent.WebParentComponent;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendParentComponent extends WebFrontendParentComponentPart , WebParentComponent , WebFrontendBaseComponent , WebFrontendComponent {
    WebFrontendParentComponent getComponent();
}
