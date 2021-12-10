package dev.reuise.web.frontend.parentcomponent;
import dev.reuise.web.core.parentcomponent.WebParentComponent;
import dev.reuise.web.frontend.component.Component;
import dev.reuise.web.frontend.component.WebFrontendComponent;
/**
 * Interface for ParentComponent and ParentComponentAdapter (Web frontend).
 */
public interface WebFrontendParentComponent extends WebParentComponent , WebFrontendComponent {
    /**
     * Add a child component.
     *
     * @param child
     * 		
     */
    void add(Component child);
}