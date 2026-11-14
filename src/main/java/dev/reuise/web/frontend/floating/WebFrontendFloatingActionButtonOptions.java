package dev.reuise.web.frontend.floating;
import dev.reuise.web.core.floating.WebFloatingActionButtonOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.button.WebFrontendButtonPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendFloatingActionButtonOptions extends WebFrontendComponentOptions , WebFrontendButtonPartOptions , WebFloatingActionButtonOptions , WebFrontendBaseComponentPartOptions , WebFrontendButtonOptions , WebFrontendFloatingActionButtonPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendButtonPartOptions getButtonPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
