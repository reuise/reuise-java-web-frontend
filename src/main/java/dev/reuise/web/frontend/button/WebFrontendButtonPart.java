package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebButtonPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendButtonPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebButtonPart , WebFrontendButtonFeatures {
    WebFrontendIcon getStartIcon();

    WebFrontendInlineText getLabelContainer();

    WebFrontendIcon getEndIcon();

    WebFrontendParentComponentPart getParentComponentPart();
}
