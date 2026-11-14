package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebIconButton;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendIconButton extends WebFrontendParentComponent , WebFrontendComponent , WebIconButton , WebFrontendIconButtonPart {
    WebFrontendIconButton getComponent();
}
