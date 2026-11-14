package dev.reuise.web.frontend.scriptcomponent;
import dev.reuise.web.core.scriptcomponent.WebScriptComponentPart;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
public interface WebFrontendScriptComponentPart extends WebFrontendParentComponentPart , WebFrontendComponentPart , WebScriptComponentPart , WebFrontendScriptComponentFeatures {
    WebFrontendParentComponentPart getParentComponentPart();
}
