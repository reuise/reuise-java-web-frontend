package dev.reuise.web.frontend.checkbox;
import dev.reuise.web.core.checkbox.WebCheckbox;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendCheckbox extends WebFrontendParentComponent , WebCheckbox , WebFrontendComponent , WebFrontendCheckboxPart {
    WebFrontendCheckbox getComponent();
}
