package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentAdapter;
import dev.reuise.web.frontend.component.Component;
import dev.reuise.web.frontend.document.Document.Options;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentAdapter;
/**
 * Document adapter implementation (Web frontend).
 */
public class DocumentAdapter implements WebFrontendParentComponentAdapter , WebFrontendDocument , WebDocumentAdapter {
    /**
     * Creates a new document adapter.
     */
    public DocumentAdapter(Options options) {
    }

    public void add(Component child) {
    }
}