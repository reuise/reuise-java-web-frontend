package dev.reuise.web.frontend.carousel;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.core.option.ComponentOption;
import dev.reuise.web.core.carousel.WebCarouselPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
import java.util.function.Consumer;
public interface WebFrontendCarouselPartOptions extends WebCarouselPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    Consumer<Integer> getOnActiveIndexChange();

    ComponentOption<Consumer<Integer>> getOnActiveIndexChangeOption();

    WebFrontendCarouselPartOptions setOnActiveIndexChange(Consumer<Integer> onActiveIndexChange);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendCarouselPartOptions setViewportCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> viewportCreator);

    WebFrontendCarouselPartOptions setSliderCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> sliderCreator);

    WebFrontendCarouselPartOptions setNavigationCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> navigationCreator);

    WebFrontendCarouselPartOptions setPreviousButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> previousButtonCreator);

    WebFrontendCarouselPartOptions setIndicatorsCreator(ComponentCreator<? extends WebFrontendContainer, ? extends WebFrontendContainerOptions> indicatorsCreator);

    WebFrontendCarouselPartOptions setNextButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> nextButtonCreator);

    WebFrontendCarouselPartOptions setAutoplayButtonCreator(ComponentCreator<? extends WebFrontendButton, ? extends WebFrontendButtonOptions> autoplayButtonCreator);

    WebFrontendCarouselPartOptions setAnnouncementCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> announcementCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendCarousel getComponent();
}
