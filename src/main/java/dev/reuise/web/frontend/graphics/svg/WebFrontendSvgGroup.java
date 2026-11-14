package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgGroup;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSvgGroup extends WebSvgGroup , WebFrontendSvg , WebFrontendComponent , WebFrontendSvgGroupPart {
    WebFrontendSvgGroup getComponent();
}
