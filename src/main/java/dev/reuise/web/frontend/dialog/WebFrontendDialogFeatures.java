package dev.reuise.web.frontend.dialog;
import dev.reuise.web.core.dialog.WebDialogFeatures;
import dev.reuise.web.frontend.event.BooleanEventHandler;
public interface WebFrontendDialogFeatures extends WebDialogFeatures {
    BooleanEventHandler getAcceptHandler();

    WebFrontendDialogFeatures setAcceptHandler(BooleanEventHandler acceptHandler);

    BooleanEventHandler getCancelHandler();

    WebFrontendDialogFeatures setCancelHandler(BooleanEventHandler cancelHandler);
}
