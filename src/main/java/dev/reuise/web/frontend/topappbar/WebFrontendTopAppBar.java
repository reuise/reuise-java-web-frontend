package dev.reuise.web.frontend.topappbar;
import dev.reuise.web.core.topappbar.WebTopAppBar;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendTopAppBar extends WebFrontendParentComponent , WebTopAppBar , WebFrontendComponent , WebFrontendTopAppBarPart {
    WebFrontendTopAppBar getComponent();
}
