package dev.reuise.web.frontend.chip;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.chip.WebChipGroup;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFieldSet;
public interface WebFrontendChipGroup extends WebFrontendChipGroupPart , WebFrontendComponent , WebChipGroup , WebFrontendFieldSet {
    WebFrontendChipGroup getComponent();

    WebFrontendChipGroup setAnimation(ComponentAnimation animation);

    WebFrontendChipGroup startAnimation();

    WebFrontendChipGroup cancelAnimation();
}
