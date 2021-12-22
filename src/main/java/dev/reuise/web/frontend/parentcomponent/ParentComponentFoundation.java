package dev.reuise.web.frontend.parentcomponent;
import dev.reuise.web.core.parentcomponent.WebParentComponentFoundation;
import dev.reuise.web.frontend.component.ComponentFoundation;
public class ParentComponentFoundation {
    private final ComponentFoundation componentFoundation;

    private final WebParentComponentFoundation webParentComponentFoundation;

    public ParentComponentFoundation(ParentComponentAdapter adapter, ParentComponentOptions options) {
        this.componentFoundation = new ComponentFoundation(adapter, options.getComponentOptions());
        this.webParentComponentFoundation = new WebParentComponentFoundation(adapter, options.getWebParentComponentOptions());
    }
}