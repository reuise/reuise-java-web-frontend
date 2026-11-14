package dev.reuise.web.frontend.button;
import dev.reuise.web.core.button.WebIconButtonPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
// Size here??
public interface WebFrontendIconButtonPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendIconButtonFeatures , WebIconButtonPart {
    Object getSize();

    WebFrontendIconButtonPart setSize(Object size);

    WebFrontendIcon getIcon();

    WebFrontendParentComponentPart getParentComponentPart();
}
