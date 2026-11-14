package dev.reuise.web.frontend.topappbar;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.topappbar.WebTopAppBarPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendIconButton;
import dev.reuise.web.frontend.button.WebFrontendIconButtonOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendTopAppBarPartOptions extends WebTopAppBarPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendTopAppBarPartOptions setContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> containerCreator);

    WebFrontendTopAppBarPartOptions setNavigationButtonCreator(ComponentCreator<? extends WebFrontendIconButton, ? extends WebFrontendIconButtonOptions> navigationButtonCreator);

    WebFrontendTopAppBarPartOptions setTitleContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> titleContainerCreator);

    WebFrontendTopAppBarPartOptions setActionsContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> actionsContainerCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendTopAppBar getComponent();
}
