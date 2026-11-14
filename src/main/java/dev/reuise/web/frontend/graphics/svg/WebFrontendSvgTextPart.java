package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgTextPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSvgTextPart extends WebFrontendComponentPart , WebFrontendSvgPart , WebFrontendSvgTextFeatures , WebSvgTextPart {
    WebFrontendSvgPart getSvgPart();
}
