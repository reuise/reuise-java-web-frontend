package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentFoundation;
import dev.reuise.web.frontend.parentcomponent.ParentComponentFoundation;
public class DocumentFoundation {
    private final ParentComponentFoundation parentComponentFoundation;

    private final WebDocumentFoundation webDocumentFoundation;

    public DocumentFoundation(DocumentAdapter adapter, DocumentOptions options) {
        this.parentComponentFoundation = new ParentComponentFoundation(adapter, options.getParentComponentOptions());
        this.webDocumentFoundation = new WebDocumentFoundation(adapter, options.getWebDocumentOptions());
    }
}