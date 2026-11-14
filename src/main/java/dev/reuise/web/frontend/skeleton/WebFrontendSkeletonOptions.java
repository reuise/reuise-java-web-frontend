package dev.reuise.web.frontend.skeleton;
import dev.reuise.web.core.skeleton.WebSkeletonOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendSkeletonOptions extends WebFrontendComponentOptions , WebFrontendSkeletonPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions , WebSkeletonOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
