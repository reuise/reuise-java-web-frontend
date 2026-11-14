package dev.reuise.web.frontend.carousel;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.carousel.WebCarouselCard;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendCarouselCard extends WebFrontendContainer , WebFrontendCarouselCardPart , WebFrontendComponent , WebCarouselCard {
    WebFrontendCarouselCard getComponent();

    WebFrontendCarouselCard setAnimation(ComponentAnimation animation);

    WebFrontendCarouselCard startAnimation();

    WebFrontendCarouselCard cancelAnimation();
}
