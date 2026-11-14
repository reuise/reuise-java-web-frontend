package dev.reuise.web.frontend.consent;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.consent.WebConsentBanner;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
public interface WebFrontendConsentBanner extends WebConsentBanner , WebFrontendConsentBannerPart , WebFrontendFlexContainer , WebFrontendComponent {
    WebFrontendConsentBanner getComponent();

    WebFrontendConsentBanner setAnimation(ComponentAnimation animation);

    WebFrontendConsentBanner startAnimation();

    WebFrontendConsentBanner cancelAnimation();
}
