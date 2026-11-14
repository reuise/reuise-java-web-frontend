package dev.reuise.web.frontend.skeleton;
import dev.reuise.web.core.skeleton.WebSkeleton;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendSkeleton extends WebFrontendBaseComponent , WebFrontendSkeletonPart , WebSkeleton , WebFrontendComponent {
    WebFrontendSkeleton getComponent();
}
