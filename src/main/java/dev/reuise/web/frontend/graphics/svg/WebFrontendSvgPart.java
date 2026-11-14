package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendSvgPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendSvgFeatures , WebSvgPart {
    WebFrontendParentComponentPart getParentComponentPart();
}
