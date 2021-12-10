package dev.reuise.web.frontend.label;
import dev.reuise.web.core.label.WebLabelImpl;
import dev.reuise.web.frontend.component.WebFrontendComponentImpl;
/**
 * Implementation of Label (Web frontend).
 */
public class WebFrontendLabelImpl<S extends WebFrontendLabelImpl<S, A>, A extends LabelAdapter> extends WebFrontendComponentImpl<S, A> implements WebFrontendLabel {
    private final WebLabelImpl<A> webLabel;

    /**
     * Implementation of Label options.
     */
    public static class Options<S extends Options<S>> extends WebFrontendComponentImpl.Options<S> implements WebFrontendLabelOptions {
        private WebLabelImpl.Options webLabelOpts;

        public Options() {
            this.webLabelOpts = new WebLabelImpl.Options();
        }
    }

    public WebFrontendLabelImpl(LabelAdapter adapter, WebFrontendLabelOptions options) {
        super(adapter, options);
        this.webLabel = new WebLabelImpl<A>(adapter, options);
    }
}