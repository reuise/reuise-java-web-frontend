package dev.reuise.web.frontend.dialog;
import dev.reuise.web.core.dialog.WebDialogOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendDialogOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebDialogOptions , WebFrontendDialogPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
