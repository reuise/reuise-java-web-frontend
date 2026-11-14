package dev.reuise.web.frontend.floating;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.floating.WebFloatingPanelPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
public interface WebFrontendFloatingPanelPartOptions extends WebFloatingPanelPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendFloatingPanelPartOptions setTriggerCreator(ComponentCreator<? extends WebFrontendFloatingActionButton, ? extends WebFrontendFloatingActionButtonOptions> triggerCreator);

    WebFrontendFloatingPanelPartOptions setPanelCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> panelCreator);

    WebFrontendFloatingPanelPartOptions setHeaderCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> headerCreator);

    WebFrontendFloatingPanelPartOptions setTitleContainerCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> titleContainerCreator);

    WebFrontendFloatingPanelPartOptions setMinimiseButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> minimiseButtonCreator);

    WebFrontendFloatingPanelPartOptions setCloseButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> closeButtonCreator);

    WebFrontendFloatingPanelPartOptions setContentCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> contentCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendFloatingPanel getComponent();
}
