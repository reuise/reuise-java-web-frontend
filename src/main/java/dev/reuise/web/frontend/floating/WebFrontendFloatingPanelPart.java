package dev.reuise.web.frontend.floating;
import dev.reuise.web.core.floating.WebFloatingPanelPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendFloatingPanelPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendFloatingPanelFeatures , WebFloatingPanelPart {
    void dispose();

    WebFrontendFloatingActionButton getTrigger();

    WebFrontendContainer getPanel();

    WebFrontendContainer getHeader();

    WebFrontendInlineText getTitleContainer();

    WebFrontendButton getMinimiseButton();

    WebFrontendButton getCloseButton();

    WebFrontendContainer getContent();

    WebFrontendContainerPart getContainerPart();
}
