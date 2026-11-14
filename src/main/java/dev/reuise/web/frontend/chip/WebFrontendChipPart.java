package dev.reuise.web.frontend.chip;
import dev.reuise.web.core.chip.WebChipPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendLabel;
public interface WebFrontendChipPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebChipPart , WebFrontendChipFeatures {
    WebFrontendIcon getStartIcon();

    WebFrontendLabel getLabelContainer();

    WebFrontendIcon getEndIcon();

    WebFrontendParentComponentPart getParentComponentPart();
}
