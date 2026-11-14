package dev.reuise.web.frontend.chip;
import dev.reuise.web.core.chip.WebChipGroupPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendFieldSetPart;
public interface WebFrontendChipGroupPart extends WebFrontendComponentPart , WebFrontendChipGroupFeatures , WebChipGroupPart , WebFrontendFieldSetPart {
    WebFrontendChip getAddButton();

    WebFrontendFieldSetPart getFieldSetPart();
}
