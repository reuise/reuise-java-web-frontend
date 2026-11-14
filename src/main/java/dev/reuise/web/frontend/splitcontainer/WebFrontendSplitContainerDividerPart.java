package dev.reuise.web.frontend.splitcontainer;
import dev.reuise.web.core.splitcontainer.WebSplitContainerDividerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendSplitContainerDividerPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebSplitContainerDividerPart , WebFrontendSplitContainerDividerFeatures {
    WebFrontendContainerPart getContainerPart();
}
