package dev.reuise.web.frontend.card;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.card.WebCard;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendSurface;
public interface WebFrontendCard extends WebFrontendCardPart , WebCard , WebFrontendSurface , WebFrontendComponent {
    WebFrontendCard getComponent();

    WebFrontendCard setAnimation(ComponentAnimation animation);

    WebFrontendCard startAnimation();

    WebFrontendCard cancelAnimation();
}
