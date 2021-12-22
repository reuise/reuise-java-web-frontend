package dev.reuise.web.frontend.parentcomponent;
import dev.reuise.web.core.parentcomponent.WebParentComponentAdapter;
import dev.reuise.web.frontend.component.Component;
import dev.reuise.web.frontend.component.ComponentAdapter;
/**
 * ParentComponent adapter implementation (Web frontend).
 */
public class ParentComponentAdapter extends ComponentAdapter implements WebFrontendParentComponent , WebParentComponentAdapter {
    /**
     * Creates a new parentcomponent adapter.
     */
    public ParentComponentAdapter(ParentComponentOptions options) {
        super(options.getComponentOptions());
    }

    public void add(Component child) {
    }
}