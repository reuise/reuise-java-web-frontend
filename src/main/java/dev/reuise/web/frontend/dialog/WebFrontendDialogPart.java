package dev.reuise.web.frontend.dialog;
import dev.reuise.web.core.dialog.WebDialogPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendHeading;
public interface WebFrontendDialogPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendDialogFeatures , WebDialogPart {
    WebFrontendContainer getContainer();

    WebFrontendContainer getHeader();

    WebFrontendHeading getTitleHeading();

    WebFrontendFlexContainer getBody();

    WebFrontendFlexContainer getFooter();

    WebFrontendContainer getScrim();

    WebFrontendButton getAcceptButton();

    WebFrontendButton getCancelButton();

    WebFrontendParentComponentPart getParentComponentPart();
}
