package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebText;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendText extends WebText , WebFrontendParentComponent , WebFrontendComponent , WebFrontendTextPart {
    WebFrontendText getComponent();
}
