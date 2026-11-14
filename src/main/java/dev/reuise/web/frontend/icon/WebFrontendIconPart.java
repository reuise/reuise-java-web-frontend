package dev.reuise.web.frontend.icon;
import dev.reuise.web.core.icon.WebIconPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvg;
import dev.reuise.web.frontend.image.WebFrontendImage;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendIconPart extends WebIconPart , WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendIconFeatures {
    WebFrontendSvg getSvg();

    WebFrontendLink getLink();

    WebFrontendImage getImage();

    WebFrontendParentComponentPart getParentComponentPart();
}
