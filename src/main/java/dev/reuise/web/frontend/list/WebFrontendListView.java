package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebListView;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendListView extends WebFrontendParentComponent , WebListView , WebFrontendComponent , WebFrontendListViewPart {
    WebFrontendListView getComponent();
}
