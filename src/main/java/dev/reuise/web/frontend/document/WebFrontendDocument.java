package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocument;
import dev.reuise.web.frontend.component.Component;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
/**
 * Interface for Document and DocumentAdapter (Web frontend).
 */
public interface WebFrontendDocument extends WebFrontendParentComponent , WebDocument {
    /**
     * Add a child component.
     *
     * @param child
     * 		
     */
    void add(Component child);
}