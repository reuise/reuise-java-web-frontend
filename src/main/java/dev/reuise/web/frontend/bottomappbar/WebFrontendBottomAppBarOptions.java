package dev.reuise.web.frontend.bottomappbar;
import dev.reuise.web.core.bottomappbar.WebBottomAppBarOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendBottomAppBarOptions extends WebFrontendComponentOptions , WebFrontendBottomAppBarPartOptions , WebFrontendBaseComponentPartOptions , WebBottomAppBarOptions , WebFrontendBaseComponentOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
