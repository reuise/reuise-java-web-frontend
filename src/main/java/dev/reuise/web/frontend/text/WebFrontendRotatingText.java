package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebRotatingText;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendRotatingText extends WebFrontendBaseComponent , WebFrontendComponent , WebRotatingText , WebFrontendRotatingTextPart {
    WebFrontendRotatingText getComponent();
}
