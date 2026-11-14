package dev.reuise.web.frontend.card;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.card.WebCardGrid;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendCardGrid extends WebFrontendContainer , WebCardGrid , WebFrontendCardGridPart , WebFrontendComponent {
    WebFrontendCardGrid getComponent();

    WebFrontendCardGrid setAnimation(ComponentAnimation animation);

    WebFrontendCardGrid startAnimation();

    WebFrontendCardGrid cancelAnimation();
}
