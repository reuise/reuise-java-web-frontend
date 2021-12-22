package dev.reuise.web.frontend.label;
import dev.reuise.web.core.label.WebLabelFoundation;
import dev.reuise.web.frontend.component.ComponentFoundation;
public class LabelFoundation {
    private final ComponentFoundation componentFoundation;

    private final WebLabelFoundation webLabelFoundation;

    public LabelFoundation(LabelAdapter adapter, LabelOptions options) {
        this.componentFoundation = new ComponentFoundation(adapter, options.getComponentOptions());
        this.webLabelFoundation = new WebLabelFoundation(adapter, options.getWebLabelOptions());
    }
}