package dev.reuise.web.frontend.scriptcomponent;
import dev.reuise.web.core.scriptcomponent.WebScriptComponent;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendScriptComponent extends WebFrontendParentComponent , WebFrontendScriptComponentPart , WebScriptComponent , WebFrontendComponent {
    WebFrontendScriptComponent getComponent();
}
