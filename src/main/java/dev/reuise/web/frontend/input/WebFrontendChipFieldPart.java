package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebChipFieldPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.chip.WebFrontendChipGroup;
public interface WebFrontendChipFieldPart extends WebFrontendTextFieldPart , WebFrontendComponentPart , WebChipFieldPart , WebFrontendChipFieldFeatures {
    WebFrontendChipGroup getChipGroup();

    WebFrontendTextFieldPart getTextFieldPart();
}
