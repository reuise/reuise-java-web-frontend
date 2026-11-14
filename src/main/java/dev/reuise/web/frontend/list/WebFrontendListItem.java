package dev.reuise.web.frontend.list;
import dev.reuise.web.core.list.WebListItem;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendListItem extends WebListItem , WebFrontendBasicListItem , WebFrontendComponent , WebFrontendListItemPart {
    WebFrontendListItem getComponent();
}
