package dev.reuise.web.frontend.layout;
import dev.reuise.web.core.layout.WebSheetLayoutPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerPart;
public interface WebFrontendSheetLayoutPart extends WebFrontendComponentPart , WebFrontendSheetLayoutFeatures , WebSheetLayoutPart , WebFrontendSplitContainerPart {
    WebFrontendSplitContainerPart getSplitContainerPart();
}
