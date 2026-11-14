package dev.reuise.web.frontend.tabs;
import dev.reuise.web.core.tabs.WebTab;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTab extends WebTab , WebFrontendParentComponent , WebFrontendTabPart , WebFrontendComponent {
    WebFrontendTab getComponent();
}
