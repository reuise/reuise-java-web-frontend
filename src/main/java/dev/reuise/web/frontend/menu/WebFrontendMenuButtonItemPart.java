package dev.reuise.web.frontend.menu;
import dev.reuise.web.core.menu.WebMenuButtonItemPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButtonPart;
public interface WebFrontendMenuButtonItemPart extends WebFrontendComponentPart , WebFrontendButtonPart , WebFrontendMenuButtonItemFeatures , WebMenuButtonItemPart {
    WebFrontendButtonPart getButtonPart();
}
