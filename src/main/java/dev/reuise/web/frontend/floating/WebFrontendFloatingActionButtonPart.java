package dev.reuise.web.frontend.floating;
import dev.reuise.web.core.floating.WebFloatingActionButtonPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButtonPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
public interface WebFrontendFloatingActionButtonPart extends WebFrontendComponentPart , WebFrontendFloatingActionButtonFeatures , WebFrontendButtonPart , WebFloatingActionButtonPart {
    WebFrontendInlineText getBadge();

    WebFrontendButtonPart getButtonPart();
}
