package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendDocumentPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebDocumentPart , WebFrontendDocumentFeatures {
    WebFrontendDocumentBody getBody();

    WebFrontendParentComponentPart getParentComponentPart();
}
