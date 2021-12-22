package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebButtonAdapter;
import dev.reuise.web.frontend.component.ComponentAdapter;
/**
 * Button adapter implementation (Web frontend).
 */
public class ButtonAdapter extends ComponentAdapter implements WebButtonAdapter , WebFrontendButton {
    /**
     * Creates a new button adapter.
     */
    public ButtonAdapter(ButtonOptions options) {
        super(options.getComponentOptions());
    }
}