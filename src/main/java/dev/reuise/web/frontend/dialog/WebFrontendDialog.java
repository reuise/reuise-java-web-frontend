package dev.reuise.web.frontend.dialog;
import dev.reuise.web.core.dialog.WebDialog;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendDialog extends WebFrontendDialogPart , WebFrontendParentComponent , WebDialog , WebFrontendComponent {
    WebFrontendDialog getComponent();
}
