package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebMultiEmailAddressField;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendMultiEmailAddressField extends WebFrontendChipField , WebMultiEmailAddressField , WebFrontendMultiEmailAddressFieldPart , WebFrontendComponent {
    WebFrontendMultiEmailAddressField getComponent();
}
