package dev.reuise.web.frontend.basecomponent;
import dev.reuise.web.core.basecomponent.WebBaseComponent;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendBaseComponent extends WebFrontendBaseComponentPart , WebFrontendComponent , WebBaseComponent {
    WebFrontendBaseComponent getComponent();
}
