package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgGroupPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSvgGroupPart extends WebFrontendSvgGroupFeatures , WebFrontendComponentPart , WebFrontendSvgPart , WebSvgGroupPart {
    WebFrontendSvgPart getSvgPart();
}
