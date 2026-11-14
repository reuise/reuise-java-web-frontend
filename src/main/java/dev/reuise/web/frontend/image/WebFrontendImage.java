package dev.reuise.web.frontend.image;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.image.WebImage;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendImage extends WebFrontendBaseComponent , WebImage , WebFrontendComponent , WebFrontendImagePart {
    WebFrontendImage getComponent();

    WebFrontendImage setAnimation(ComponentAnimation animation);

    WebFrontendImage startAnimation();

    WebFrontendImage cancelAnimation();
}
