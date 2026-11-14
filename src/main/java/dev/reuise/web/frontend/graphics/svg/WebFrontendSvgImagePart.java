package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgImagePart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSvgImagePart extends WebFrontendComponentPart , WebSvgImagePart , WebFrontendSvgPart , WebFrontendSvgImageFeatures {
    WebFrontendSvgPart getSvgPart();
}
