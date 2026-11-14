package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebButton;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendButton extends WebFrontendParentComponent , WebFrontendButtonPart , WebButton , WebFrontendComponent {
    WebFrontendButton getComponent();
}
