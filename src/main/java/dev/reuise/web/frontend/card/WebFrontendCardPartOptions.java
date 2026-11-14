package dev.reuise.web.frontend.card;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.card.WebCardPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.image.WebFrontendImage;
import dev.reuise.web.frontend.image.WebFrontendImageOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendSurfacePartOptions;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.link.WebFrontendLinkOptions;
import dev.reuise.web.frontend.text.WebFrontendTextBlock;
import dev.reuise.web.frontend.text.WebFrontendTextBlockOptions;
public interface WebFrontendCardPartOptions extends WebCardPartOptions {
    WebFrontendSurfacePartOptions getSurfacePart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendCardPartOptions setMediaLinkCreator(ComponentCreator<? extends WebFrontendLink, ? extends WebFrontendLinkOptions> mediaLinkCreator);

    WebFrontendCardPartOptions setMediaContainerCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> mediaContainerCreator);

    WebFrontendCardPartOptions setImageCreator(ComponentCreator<? extends WebFrontendImage, ? extends WebFrontendImageOptions> imageCreator);

    WebFrontendCardPartOptions setTextContentCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> textContentCreator);

    WebFrontendCardPartOptions setHeadlineCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> headlineCreator);

    WebFrontendCardPartOptions setHeadingLinkCreator(ComponentCreator<? extends WebFrontendLink, ? extends WebFrontendLinkOptions> headingLinkCreator);

    WebFrontendCardPartOptions setHeadingContainerCreator(ComponentCreator<? extends WebFrontendTextBlock, ? extends WebFrontendTextBlockOptions> headingContainerCreator);

    WebFrontendCardPartOptions setSubHeadingContainerCreator(ComponentCreator<? extends WebFrontendTextBlock, ? extends WebFrontendTextBlockOptions> subHeadingContainerCreator);

    WebFrontendCardPartOptions setTextContainerCreator(ComponentCreator<? extends WebFrontendTextBlock, ? extends WebFrontendTextBlockOptions> textContainerCreator);

    WebFrontendCardPartOptions setActionsContainerCreator(ComponentCreator<? extends WebFrontendFlexContainer, ? extends WebFrontendFlexContainerOptions> actionsContainerCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendCard getComponent();
}
