package dev.reuise.web.frontend.banner;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.banner.WebBannerPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPartOptions;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
import dev.reuise.web.frontend.text.WebFrontendParagraphOptions;
public interface WebFrontendBannerPartOptions extends WebBannerPartOptions {
    WebFrontendFlexContainerPartOptions getFlexContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendBannerPartOptions setIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> iconCreator);

    WebFrontendBannerPartOptions setContentCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> contentCreator);

    WebFrontendBannerPartOptions setMessageParagraphCreator(ComponentCreator<? extends WebFrontendParagraph, ? extends WebFrontendParagraphOptions> messageParagraphCreator);

    WebFrontendBannerPartOptions setActionsCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> actionsCreator);

    WebFrontendBannerPartOptions setDismissButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> dismissButtonCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendBanner getComponent();
}
