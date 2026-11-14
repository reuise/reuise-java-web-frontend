package dev.reuise.web.frontend.checkbox;
import dev.reuise.core.checkbox.CheckboxSize;
import dev.reuise.web.core.checkbox.WebCheckboxPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendLabel;
// Size here??
public interface WebFrontendCheckboxPart extends WebFrontendParentComponentPart , WebCheckboxPart , WebFrontendComponentPart , WebFrontendCheckboxFeatures {
    CheckboxSize getSize();

    WebFrontendCheckboxPart setSize(CheckboxSize size);

    WebFrontendBasicCheckbox getCheckbox();

    WebFrontendLabel getLabelContainer();

    WebFrontendParentComponentPart getParentComponentPart();
}
