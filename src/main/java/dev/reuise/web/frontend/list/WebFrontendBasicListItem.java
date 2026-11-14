package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebBasicListItem;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendBasicListItem extends WebFrontendParentComponent , WebBasicListItem , WebFrontendBasicListItemPart , WebFrontendComponent {
    WebFrontendBasicListItem getComponent();
}
