package dev.reuise.web.frontend.graphics.svg;
import dev.reuise.web.core.graphics.svg.WebSvgImage;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendSvgImage extends WebSvgImage , WebFrontendSvg , WebFrontendComponent , WebFrontendSvgImagePart {
    WebFrontendSvgImage getComponent();
}
