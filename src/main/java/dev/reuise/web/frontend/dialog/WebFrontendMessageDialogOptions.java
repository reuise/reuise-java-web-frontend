package dev.reuise.web.frontend.dialog;
import dev.reuise.web.core.dialog.WebMessageDialogOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendMessageDialogOptions extends WebFrontendComponentOptions , WebFrontendDialogPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendDialogOptions , WebFrontendMessageDialogPartOptions , WebMessageDialogOptions , WebFrontendParentComponentPartOptions {
    WebFrontendDialogPartOptions getDialogPart();

    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
