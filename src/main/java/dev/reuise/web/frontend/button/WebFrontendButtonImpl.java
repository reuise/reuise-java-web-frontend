package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebButtonImpl;
import dev.reuise.web.frontend.component.WebFrontendComponentImpl;
/**
 * Implementation of Button (Web frontend).
 */
public class WebFrontendButtonImpl<S extends WebFrontendButtonImpl<S, A>, A extends ButtonAdapter> extends WebFrontendComponentImpl<S, A> implements WebFrontendButton {
    private final WebButtonImpl<A> webButton;

    /**
     * Implementation of Button options.
     */
    public static class Options<S extends Options<S>> extends WebFrontendComponentImpl.Options<S> implements WebFrontendButtonOptions {
        private WebButtonImpl.Options webButtonOpts;

        /**
         * Gets the label on the button
         *
         * @return Label
         */
        public String getLabel() {
            return webButtonOpts.getLabel();
        }

        /**
         * Sets the label on the button
         *
         * @param label:
         * 		Label
         * @return Options instance
         */
        public S setLabel(String label) {
            webButtonOpts.setLabel(label);
            return self();
        }

        public Options() {
            this.webButtonOpts = new WebButtonImpl.Options();
        }
    }

    public WebFrontendButtonImpl(ButtonAdapter adapter, WebFrontendButtonOptions options) {
        super(adapter, options);
        this.webButton = new WebButtonImpl<A>(adapter, options);
    }
}