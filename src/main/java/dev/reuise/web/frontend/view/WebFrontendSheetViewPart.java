package dev.reuise.web.frontend.view;
import dev.reuise.web.core.view.WebSheetViewPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
public interface WebFrontendSheetViewPart extends WebFrontendComponentPart , WebSheetViewPart , WebFrontendViewPart , WebFrontendSheetViewFeatures {
    WebFrontendViewPart getViewPart();
}
