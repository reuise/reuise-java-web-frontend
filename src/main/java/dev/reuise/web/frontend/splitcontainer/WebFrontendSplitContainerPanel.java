package dev.reuise.web.frontend.splitcontainer;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.splitcontainer.WebSplitContainerPanel;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendSplitContainerPanel extends WebFrontendContainer , WebFrontendSplitContainerPanelPart , WebSplitContainerPanel , WebFrontendComponent {
    WebFrontendSplitContainerPanel getComponent();

    WebFrontendSplitContainerPanel setAnimation(ComponentAnimation animation);

    WebFrontendSplitContainerPanel startAnimation();

    WebFrontendSplitContainerPanel cancelAnimation();
}
