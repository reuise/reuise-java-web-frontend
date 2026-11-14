package dev.reuise.web.frontend.splitcontainer;
import dev.reuise.web.core.splitcontainer.WebSplitContainerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
public interface WebFrontendSplitContainerPart extends WebFrontendComponentPart , WebFrontendContainerPart , WebFrontendSplitContainerFeatures , WebSplitContainerPart {
    WebFrontendContainer getContainer();

    WebFrontendSplitContainerPanel getStartPanel();

    WebFrontendSplitContainerDivider getDivider();

    WebFrontendSplitContainerPanel getEndPanel();

    WebFrontendContainerPart getContainerPart();
}
