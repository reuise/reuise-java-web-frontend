package dev.reuise.web.frontend.checkbox;
import dev.reuise.web.core.checkbox.WebBasicCheckbox;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendBasicCheckbox extends WebBasicCheckbox , WebFrontendBaseComponent , WebFrontendBasicCheckboxPart , WebFrontendComponent {
    WebFrontendBasicCheckbox getComponent();
}
