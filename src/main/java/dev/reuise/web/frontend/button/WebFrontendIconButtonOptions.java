package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebIconButtonOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendIconButtonOptions extends WebIconButtonOptions , WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions , WebFrontendIconButtonPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
