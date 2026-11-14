package dev.reuise.web.frontend.chip;
import dev.reuise.web.core.chip.WebChip;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendChip extends WebChip , WebFrontendParentComponent , WebFrontendChipPart , WebFrontendComponent {
    WebFrontendChip getComponent();
}
