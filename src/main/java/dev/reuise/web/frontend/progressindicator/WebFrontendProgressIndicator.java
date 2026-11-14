package dev.reuise.web.frontend.progressindicator;
import dev.reuise.web.core.progressindicator.WebProgressIndicator;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendProgressIndicator extends WebFrontendParentComponent , WebProgressIndicator , WebFrontendProgressIndicatorPart , WebFrontendComponent {
    WebFrontendProgressIndicator getComponent();
}
