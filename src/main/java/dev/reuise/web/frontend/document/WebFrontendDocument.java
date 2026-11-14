package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocument;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.WebFrontendRootComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendDocument extends WebFrontendDocumentPart , WebFrontendParentComponent , WebDocument , WebFrontendRootComponent , WebFrontendComponent {
    WebFrontendDocument getComponent();
}
