package dev.reuise.web.frontend.carousel;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.carousel.WebCarousel;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendCarousel extends WebFrontendContainer , WebCarousel , WebFrontendCarouselPart , WebFrontendComponent {
    WebFrontendCarousel getComponent();

    WebFrontendCarousel setAnimation(ComponentAnimation animation);

    WebFrontendCarousel startAnimation();

    WebFrontendCarousel cancelAnimation();
}
