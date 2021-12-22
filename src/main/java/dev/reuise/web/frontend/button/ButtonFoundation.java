package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebButtonFoundation;
import dev.reuise.web.frontend.component.ComponentFoundation;
public class ButtonFoundation {
    private final ComponentFoundation componentFoundation;

    private final WebButtonFoundation webButtonFoundation;

    public ButtonFoundation(ButtonAdapter adapter, ButtonOptions options) {
        this.componentFoundation = new ComponentFoundation(adapter, options.getComponentOptions());
        this.webButtonFoundation = new WebButtonFoundation(adapter, options.getWebButtonOptions());
    }
}