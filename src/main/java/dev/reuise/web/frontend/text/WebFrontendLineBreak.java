package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebLineBreak;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
public interface WebFrontendLineBreak extends WebFrontendBaseComponent , WebLineBreak , WebFrontendComponent , WebFrontendLineBreakPart {
    WebFrontendLineBreak getComponent();
}
