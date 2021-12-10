package dev.reuise.web.frontend.label;
/**
 * A Label bla bla. For use with web frontend.
 */
public final class Label extends WebFrontendLabelImpl<Label, LabelAdapter> {
    /**
     * Options for Label. For use with web frontend.
     */
    public static class Options extends WebFrontendLabelImpl.Options<Options> {
        @Override
        protected Options self() {
            return this;
        }
    }

    /**
     * Creates a new label.
     */
    public Label(Options options) {
        super(new LabelAdapter(options), options);
    }

    /**
     * Creates options to be passed to a new label.
     */
    public static Options newOptions() {
        return new Options();
    }

    @Override
    protected Label self() {
        return this;
    }
}