package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentImpl;
import dev.reuise.web.frontend.component.Component;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentImpl;
/**
 * Implementation of Document (Web frontend).
 */
public class WebFrontendDocumentImpl<S extends WebFrontendDocumentImpl<S, A>, A extends DocumentAdapter> extends WebFrontendParentComponentImpl<S, A> implements WebFrontendDocument {
    private final WebDocumentImpl<A> webDocument;

    /**
     * Implementation of Document options.
     */
    public static class Options<S extends Options<S>> extends WebFrontendParentComponentImpl.Options<S> implements WebFrontendDocumentOptions {
        private WebDocumentImpl.Options webDocumentOpts;

        public Options() {
            this.webDocumentOpts = new WebDocumentImpl.Options();
        }
    }

    public WebFrontendDocumentImpl(DocumentAdapter adapter, WebFrontendDocumentOptions options) {
        super(adapter, options);
        this.webDocument = new WebDocumentImpl<A>(adapter, options);
    }

    /**
     * Add a child component.
     *
     * @param child
     * 		
     */
    public void add(Component child) {
        super.add(child);
        webDocument.add(child);
    }
}