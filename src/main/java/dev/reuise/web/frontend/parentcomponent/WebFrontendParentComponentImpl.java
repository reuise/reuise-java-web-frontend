package dev.reuise.web.frontend.parentcomponent;
import dev.reuise.web.core.parentcomponent.WebParentComponentImpl;
import dev.reuise.web.frontend.component.Component;
import dev.reuise.web.frontend.component.WebFrontendComponentImpl;
/**
 * Implementation of ParentComponent (Web frontend).
 */
public class WebFrontendParentComponentImpl<S extends WebFrontendParentComponentImpl<S, A>, A extends WebFrontendParentComponentAdapter> extends WebFrontendComponentImpl<S, A> implements WebFrontendParentComponent {
    private final WebParentComponentImpl<A> webParentComponent;

    /**
     * Implementation of ParentComponent options.
     */
    public static class Options<S extends Options<S>> extends WebFrontendComponentImpl.Options<S> implements WebFrontendParentComponentOptions {
        public Options() {
        }
    }

    public WebFrontendParentComponentImpl(WebFrontendParentComponentAdapter adapter, WebFrontendParentComponentOptions options) {
        super(adapter, options);
        this.webParentComponent = new WebParentComponentImpl<A>(adapter, options);
    }

    /**
     * Add a child component.
     *
     * @param child
     * 		
     */
    public void add(Component child) {
        webParentComponent.add(child);
    }
}