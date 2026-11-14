package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebLabel;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendLabel extends WebLabel , WebFrontendInlineText , WebFrontendComponent , WebFrontendLabelPart {
    WebFrontendLabel getComponent();
}
