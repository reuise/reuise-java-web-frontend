package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebChipField;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendChipField extends WebFrontendComponent , WebFrontendChipFieldPart , WebChipField , WebFrontendTextField {
    WebFrontendChipField getComponent();
}
