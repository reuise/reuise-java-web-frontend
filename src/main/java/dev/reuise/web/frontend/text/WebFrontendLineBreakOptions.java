package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebLineBreakOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendLineBreakOptions extends WebFrontendComponentOptions , WebLineBreakOptions , WebFrontendLineBreakPartOptions , WebFrontendBaseComponentPartOptions , WebFrontendBaseComponentOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
