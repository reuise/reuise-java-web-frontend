package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebParagraphOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendParagraphOptions extends WebFrontendParentComponentOptions , WebFrontendComponentOptions , WebFrontendParagraphPartOptions , WebParagraphOptions , WebFrontendBaseComponentPartOptions , WebFrontendParentComponentPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
