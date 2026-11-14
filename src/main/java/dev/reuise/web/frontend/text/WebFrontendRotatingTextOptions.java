package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebRotatingTextOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendRotatingTextOptions extends WebFrontendComponentOptions , WebFrontendRotatingTextPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions , WebRotatingTextOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
