package dev.reuise.web.frontend.skeleton;
import dev.reuise.web.core.skeleton.WebSkeletonPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendSkeletonPart extends WebFrontendComponentPart , WebFrontendSkeletonFeatures , WebFrontendBaseComponentPart , WebSkeletonPart {
    WebFrontendBaseComponentPart getBaseComponentPart();
}
