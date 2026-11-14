package dev.reuise.web.frontend.filepicker;
import dev.reuise.web.core.filepicker.WebFilePickerPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
public interface WebFrontendFilePickerPart extends WebFilePickerPart , WebFrontendComponentPart , WebFrontendFilePickerFeatures , WebFrontendBaseComponentPart {
    void open();

    WebFrontendBaseComponentPart getBaseComponentPart();
}
