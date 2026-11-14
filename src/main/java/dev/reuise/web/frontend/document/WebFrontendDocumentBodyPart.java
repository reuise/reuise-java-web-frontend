package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentBodyPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendDocumentBodyPart extends WebFrontendDocumentBodyFeatures , WebFrontendParentComponentPart , WebFrontendComponentPart , WebDocumentBodyPart {
    WebFrontendParentComponentPart getParentComponentPart();
}
