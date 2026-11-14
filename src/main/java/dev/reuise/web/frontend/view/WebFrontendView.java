package dev.reuise.web.frontend.view;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.view.WebView;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
public interface WebFrontendView extends WebView , WebFrontendViewPart , WebFrontendFlexContainer , WebFrontendComponent {
    WebFrontendView getComponent();

    WebFrontendView setAnimation(ComponentAnimation animation);

    WebFrontendView startAnimation();

    WebFrontendView cancelAnimation();
}
