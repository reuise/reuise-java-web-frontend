package dev.reuise.web.frontend.filepicker;
import dev.reuise.web.core.filepicker.WebFilePickerOptions;
import dev.reuise.web.frontend.WebFrontendComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPartOptions;
// Todo: Clean up unneeded interfaces
public interface WebFrontendFilePickerOptions extends WebFrontendComponentOptions , WebFilePickerOptions , WebFrontendBaseComponentPartOptions , WebFrontendFilePickerPartOptions , WebFrontendBaseComponentOptions {
    WebFrontendBaseComponentPartOptions getBaseComponentPart();
}
