package dev.reuise.web.frontend.progressindicator;
import dev.reuise.web.core.progressindicator.WebProgressIndicatorPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendProgressIndicatorPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebProgressIndicatorPart , WebFrontendProgressIndicatorFeatures {
    WebFrontendContainer getTrack();

    WebFrontendParentComponentPart getParentComponentPart();
}
