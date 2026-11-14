package dev.reuise.web.frontend.splitcontainer;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.splitcontainer.WebSplitContainerDivider;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendSplitContainerDivider extends WebFrontendContainer , WebFrontendSplitContainerDividerPart , WebFrontendComponent , WebSplitContainerDivider {
    WebFrontendSplitContainerDivider getComponent();

    WebFrontendSplitContainerDivider setAnimation(ComponentAnimation animation);

    WebFrontendSplitContainerDivider startAnimation();

    WebFrontendSplitContainerDivider cancelAnimation();
}
