package dev.reuise.web.frontend.applayout;
import dev.reuise.web.core.applayout.WebAppLayoutPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainer;
public interface WebFrontendAppLayoutPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebFrontendAppLayoutFeatures , WebAppLayoutPart {
    WebFrontendContainer getDrawerScrim();

    WebFrontendSplitContainer getDrawerSplit();

    WebFrontendSplitContainer getTopAppBarSplit();

    WebFrontendAppLayoutBody getBody();

    WebFrontendParentComponentPart getParentComponentPart();
}
