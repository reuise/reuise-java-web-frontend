package dev.reuise.web.frontend.bottomappbar;
import dev.reuise.web.core.bottomappbar.WebBottomAppBar;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendBottomAppBar extends WebFrontendBaseComponent , WebFrontendComponent , WebBottomAppBar , WebFrontendBottomAppBarPart {
    WebFrontendBottomAppBar getComponent();
}
