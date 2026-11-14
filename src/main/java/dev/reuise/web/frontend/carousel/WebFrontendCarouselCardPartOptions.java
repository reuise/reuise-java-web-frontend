package dev.reuise.web.frontend.carousel;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.carousel.WebCarouselCardPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendContainerPartOptions;
public interface WebFrontendCarouselCardPartOptions extends WebCarouselCardPartOptions {
    WebFrontendContainerPartOptions getContainerPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendCarouselCard getComponent();
}
