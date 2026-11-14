package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentBody;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendDocumentBody extends WebDocumentBody , WebFrontendParentComponent , WebFrontendComponent , WebFrontendDocumentBodyPart {
    WebFrontendDocumentBody getComponent();
}
