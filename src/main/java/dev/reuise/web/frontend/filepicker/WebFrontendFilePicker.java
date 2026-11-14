package dev.reuise.web.frontend.filepicker;
import dev.reuise.web.core.filepicker.WebFilePicker;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendFilePicker extends WebFrontendFilePickerPart , WebFrontendBaseComponent , WebFilePicker , WebFrontendComponent {
    WebFrontendFilePicker getComponent();
}
