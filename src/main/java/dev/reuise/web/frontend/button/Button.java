package dev.reuise.web.frontend.button;
/**
 * A Button bla bla. For use with web frontend.
 */
public final class Button extends WebFrontendButtonImpl<Button, ButtonAdapter> {
    /**
     * Options for Button. For use with web frontend.
     */
    public static class Options extends WebFrontendButtonImpl.Options<Options> {
        @Override
        protected Options self() {
            return this;
        }
    }

    /**
     * Creates a new button.
     */
    public Button(Options options) {
        super(new ButtonAdapter(options), options);
    }

    /**
     * Creates options to be passed to a new button.
     */
    public static Options newOptions() {
        return new Options();
    }

    @Override
    protected Button self() {
        return this;
    }
}