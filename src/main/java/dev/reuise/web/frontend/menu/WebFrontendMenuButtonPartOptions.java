package dev.reuise.web.frontend.menu;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.menu.WebMenuButtonPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendMenuButtonPartOptions extends WebMenuButtonPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendMenuButtonPartOptions setTriggerCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> triggerCreator);

    WebFrontendMenuButtonPartOptions setPopupCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> popupCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendMenuButton getComponent();
}
