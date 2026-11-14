package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebIconLabel;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendIconLabel extends WebFrontendParentComponent , WebFrontendIconLabelPart , WebIconLabel , WebFrontendComponent {
    WebFrontendIconLabel getComponent();
}
