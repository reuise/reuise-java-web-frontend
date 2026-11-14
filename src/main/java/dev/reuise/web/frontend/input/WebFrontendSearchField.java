package dev.reuise.web.frontend.input;
import dev.reuise.web.core.input.WebSearchField;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSearchField extends WebFrontendSearchFieldPart , WebSearchField , WebFrontendComponent , WebFrontendTextField {
    WebFrontendSearchField getComponent();
}
