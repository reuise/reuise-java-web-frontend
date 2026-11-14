package dev.reuise.web.frontend.splitcontainer;
import dev.reuise.web.core.splitcontainer.WebSplitContainerPanelPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendSplitContainerPanelPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendSplitContainerPanelFeatures , WebSplitContainerPanelPart {
    WebFrontendContainerPart getContainerPart();
}
