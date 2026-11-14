package dev.reuise.web.frontend.floating;
import dev.reuise.web.core.floating.WebFloatingActionButton;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.button.WebFrontendButton;
public interface WebFrontendFloatingActionButton extends WebFrontendFloatingActionButtonPart , WebFrontendButton , WebFrontendComponent , WebFloatingActionButton {
    WebFrontendFloatingActionButton getComponent();
}
