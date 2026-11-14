package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebMultiEmailAddressFieldPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendMultiEmailAddressFieldPart extends WebFrontendComponentPart , WebFrontendMultiEmailAddressFieldFeatures , WebMultiEmailAddressFieldPart , WebFrontendChipFieldPart {
    WebFrontendChipFieldPart getChipFieldPart();
}
