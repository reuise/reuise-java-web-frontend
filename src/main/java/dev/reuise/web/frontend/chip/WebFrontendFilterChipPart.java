package dev.reuise.web.frontend.chip;
import dev.reuise.web.core.chip.WebFilterChipPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendFilterChipPart extends WebFrontendComponentPart , WebFrontendFilterChipFeatures , WebFilterChipPart , WebFrontendChipPart {
    WebFrontendChipPart getChipPart();
}
