package dev.reuise.web.frontend.button;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.button.WebIconButtonPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
// Size here??
public interface WebFrontendIconButtonPartOptions extends WebIconButtonPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    Object getSize();

    WebFrontendIconButtonPartOptions setSize(Object size);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendIconButtonPartOptions setIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> iconCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendIconButton getComponent();
}
