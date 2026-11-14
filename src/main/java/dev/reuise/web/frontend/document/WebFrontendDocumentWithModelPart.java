package dev.reuise.web.frontend.document;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendDocumentWithModelPart<M> extends WebFrontendDocumentPart , WebFrontendComponentPart , WebFrontendDocumentWithModelFeatures<M> {
    M deserializeModel(String json);

    WebFrontendDocumentPart getDocumentPart();
}
