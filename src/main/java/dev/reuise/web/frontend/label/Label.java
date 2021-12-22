package dev.reuise.web.frontend.label;
/**
 * A Label bla bla. For use with web frontend.
 */
public class Label {
    private final LabelFoundation foundation;

    /**
     * Creates a new label.
     */
    public Label(LabelOptions options) {
        this.foundation = new LabelFoundation(new LabelAdapter(options), options);
    }

    /**
     * Creates options to be passed to a new label.
     */
    public static LabelOptions newOptions() {
        return new LabelOptions();
    }
}