package dev.reuise.web.frontend.dialog;
import dev.reuise.web.core.dialog.WebMessageDialog;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendMessageDialog extends WebFrontendDialog , WebFrontendMessageDialogPart , WebFrontendComponent , WebMessageDialog {
    WebFrontendMessageDialog getComponent();
}
