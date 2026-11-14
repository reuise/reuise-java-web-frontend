package dev.reuise.web.frontend.view;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.view.WebSheetView;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSheetView extends WebFrontendView , WebSheetView , WebFrontendSheetViewPart , WebFrontendComponent {
    WebFrontendSheetView getComponent();

    WebFrontendSheetView setAnimation(ComponentAnimation animation);

    WebFrontendSheetView startAnimation();

    WebFrontendSheetView cancelAnimation();
}
