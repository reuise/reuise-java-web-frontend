package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebRowLayoutPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendRowLayoutPart extends WebFrontendRowLayoutFeatures , WebFrontendComponentPart , WebFrontendFlexContainerPart , WebRowLayoutPart {
    WebFrontendFlexContainerPart getFlexContainerPart();
}
