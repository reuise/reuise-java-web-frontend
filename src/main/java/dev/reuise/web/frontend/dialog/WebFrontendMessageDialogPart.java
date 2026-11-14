package dev.reuise.web.frontend.dialog;
import dev.reuise.web.core.dialog.WebMessageDialogPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendMessageDialogPart extends WebFrontendDialogPart , WebMessageDialogPart , WebFrontendComponentPart , WebFrontendMessageDialogFeatures {
    WebFrontendDialogPart getDialogPart();
}
