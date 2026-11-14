package dev.reuise.web.frontend.dialog;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.core.option.ComponentOption;
import dev.reuise.web.core.dialog.WebDialogPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.event.BooleanEventHandler;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendHeading;
import dev.reuise.web.frontend.text.WebFrontendHeadingOptions;
public interface WebFrontendDialogPartOptions extends WebDialogPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    BooleanEventHandler getAcceptHandler();

    ComponentOption<BooleanEventHandler> getAcceptHandlerOption();

    WebFrontendDialogPartOptions setAcceptHandler(BooleanEventHandler acceptHandler);

    BooleanEventHandler getCancelHandler();

    ComponentOption<BooleanEventHandler> getCancelHandlerOption();

    WebFrontendDialogPartOptions setCancelHandler(BooleanEventHandler cancelHandler);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendDialogPartOptions setContainerCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> containerCreator);

    WebFrontendDialogPartOptions setHeaderCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> headerCreator);

    WebFrontendDialogPartOptions setTitleHeadingCreator(ComponentCreator<? extends WebFrontendHeading, ? extends WebFrontendHeadingOptions> titleHeadingCreator);

    WebFrontendDialogPartOptions setBodyCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> bodyCreator);

    WebFrontendDialogPartOptions setFooterCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> footerCreator);

    WebFrontendDialogPartOptions setScrimCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> scrimCreator);

    WebFrontendDialogPartOptions setAcceptButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> acceptButtonCreator);

    WebFrontendDialogPartOptions setCancelButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> cancelButtonCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendDialog getComponent();
}
