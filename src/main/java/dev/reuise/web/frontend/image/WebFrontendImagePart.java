package dev.reuise.web.frontend.image;
import dev.reuise.web.core.image.WebImagePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.link.WebFrontendLink;
public interface WebFrontendImagePart extends WebFrontendComponentPart , WebFrontendBaseComponentPart , WebImagePart , WebFrontendImageFeatures {
    WebFrontendLink getLink();

    WebFrontendBaseComponentPart getBaseComponentPart();
}
