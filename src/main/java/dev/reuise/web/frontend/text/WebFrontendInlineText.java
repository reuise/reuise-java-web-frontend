package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebInlineText;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendInlineText extends WebFrontendText , WebInlineText , WebFrontendComponent , WebFrontendInlineTextPart {
    WebFrontendInlineText getComponent();
}
