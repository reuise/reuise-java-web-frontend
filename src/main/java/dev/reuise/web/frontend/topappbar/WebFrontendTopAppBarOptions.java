package dev.reuise.web.frontend.topappbar;
import dev.reuise.web.core.topappbar.WebTopAppBarOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendTopAppBarOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebTopAppBarOptions , WebFrontendBaseComponentPartOptions , WebFrontendTopAppBarPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
