package dev.reuise.web.frontend.carousel;
import dev.reuise.web.core.carousel.WebCarouselFeatures;
import java.util.function.Consumer;
public interface WebFrontendCarouselFeatures extends WebCarouselFeatures {
    Consumer<Integer> getOnActiveIndexChange();

    WebFrontendCarouselFeatures setOnActiveIndexChange(Consumer<Integer> onActiveIndexChange);
}
