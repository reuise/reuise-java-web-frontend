package dev.reuise.web.frontend.banner;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.banner.WebBanner;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
public interface WebFrontendBanner extends WebFrontendBannerPart , WebBanner , WebFrontendFlexContainer , WebFrontendComponent {
    WebFrontendBanner getComponent();

    WebFrontendBanner setAnimation(ComponentAnimation animation);

    WebFrontendBanner startAnimation();

    WebFrontendBanner cancelAnimation();
}
