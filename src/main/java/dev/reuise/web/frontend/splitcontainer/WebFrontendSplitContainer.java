package dev.reuise.web.frontend.splitcontainer;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.splitcontainer.WebSplitContainer;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendSplitContainer extends WebFrontendContainer , WebSplitContainer , WebFrontendComponent , WebFrontendSplitContainerPart {
    WebFrontendSplitContainer getComponent();

    WebFrontendSplitContainer setAnimation(ComponentAnimation animation);

    WebFrontendSplitContainer startAnimation();

    WebFrontendSplitContainer cancelAnimation();
}
