package dev.reuise.web.frontend.layout;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.layout.WebSheetLayout;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainer;
public interface WebFrontendSheetLayout extends WebFrontendSplitContainer , WebFrontendSheetLayoutPart , WebFrontendComponent , WebSheetLayout {
    WebFrontendSheetLayout getComponent();

    WebFrontendSheetLayout setAnimation(ComponentAnimation animation);

    WebFrontendSheetLayout startAnimation();

    WebFrontendSheetLayout cancelAnimation();
}
