package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuButtonPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendMenuButtonPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebMenuButtonPart , WebFrontendMenuButtonFeatures {
    void dispose();

    WebFrontendButton getTrigger();

    WebFrontendContainer getPopup();

    WebFrontendContainerPart getContainerPart();
}
