package dev.reuise.web.frontend.label;
import dev.reuise.web.core.label.WebLabelAdapter;
import dev.reuise.web.frontend.component.ComponentAdapter;
/**
 * Label adapter implementation (Web frontend).
 */
public class LabelAdapter extends ComponentAdapter implements WebLabelAdapter , WebFrontendLabel {
    /**
     * Creates a new label adapter.
     */
    public LabelAdapter(LabelOptions options) {
        super(options.getComponentOptions());
    }
}