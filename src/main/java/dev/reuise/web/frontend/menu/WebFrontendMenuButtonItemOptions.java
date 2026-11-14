package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuButtonItemOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.button.WebFrontendButtonPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendMenuButtonItemOptions extends WebFrontendComponentOptions , WebFrontendButtonPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendButtonOptions , WebFrontendParentComponentPartOptions , WebFrontendMenuButtonItemPartOptions , WebMenuButtonItemOptions {
    WebFrontendButtonPartOptions getButtonPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
