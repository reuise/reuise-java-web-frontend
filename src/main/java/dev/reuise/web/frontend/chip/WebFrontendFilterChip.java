package dev.reuise.web.frontend.chip;
import dev.reuise.web.core.chip.WebFilterChip;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendFilterChip extends WebFrontendChip , WebFrontendFilterChipPart , WebFilterChip , WebFrontendComponent {
    WebFrontendFilterChip getComponent();
}
