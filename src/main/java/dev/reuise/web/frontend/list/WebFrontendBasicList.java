package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebBasicList;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendBasicList extends WebFrontendParentComponent , WebBasicList , WebFrontendBasicListPart , WebFrontendComponent {
    WebFrontendBasicList getComponent();
}
