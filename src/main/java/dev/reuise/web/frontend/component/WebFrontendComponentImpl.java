package dev.reuise.web.frontend.component;
import dev.reuise.web.core.component.WebComponentImpl;
/**
 * Implementation of Component (Web frontend).
 */
public class WebFrontendComponentImpl<S extends WebFrontendComponentImpl<S, A>, A extends WebFrontendComponentAdapter> extends WebComponentImpl<S, A> implements Component {
    /**
     * Implementation of Component options.
     */
    public static class Options<S extends Options<S>> extends WebComponentImpl.Options<S> implements WebFrontendComponentOptions {
        public Options() {
        }
    }

    public WebFrontendComponentImpl(WebFrontendComponentAdapter adapter, WebFrontendComponentOptions options) {
        super(adapter, options);
    }

    protected S self() {
        return null;
    }
}