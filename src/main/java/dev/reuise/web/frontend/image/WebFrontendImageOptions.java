package dev.reuise.web.frontend.image;
import dev.reuise.web.core.image.WebImageOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendImageOptions extends WebFrontendComponentOptions , WebImageOptions , WebFrontendImagePartOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
