package dev.reuise.web.frontend.floating;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.floating.WebFloatingPanel;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
public interface WebFrontendFloatingPanel extends WebFrontendContainer , WebFrontendFloatingPanelPart , WebFrontendComponent , WebFloatingPanel {
    WebFrontendFloatingPanel getComponent();

    WebFrontendFloatingPanel setAnimation(ComponentAnimation animation);

    WebFrontendFloatingPanel startAnimation();

    WebFrontendFloatingPanel cancelAnimation();
}
