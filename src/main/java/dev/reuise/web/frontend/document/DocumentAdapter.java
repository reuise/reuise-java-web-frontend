package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentAdapter;
import dev.reuise.web.frontend.component.Component;
import dev.reuise.web.frontend.parentcomponent.ParentComponentAdapter;
/**
 * Document adapter implementation (Web frontend).
 */
public class DocumentAdapter extends ParentComponentAdapter implements WebFrontendDocument , WebDocumentAdapter {
    /**
     * Creates a new document adapter.
     */
    public DocumentAdapter(DocumentOptions options) {
        super(options.getParentComponentOptions());
    }

    public void add(Component child) {
    }
}