package dev.reuise.web.frontend.document;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.WebFrontendRootComponent;
public interface WebFrontendDocumentWithModel<M> extends WebFrontendDocument , WebFrontendDocumentWithModelPart<M> , WebFrontendRootComponent , WebFrontendComponent {
    WebFrontendDocumentWithModel getComponent();
}
