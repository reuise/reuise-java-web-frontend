package dev.reuise.web.frontend.dropzone;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.dropzone.WebDropZonePartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
public interface WebFrontendDropZonePartOptions extends WebDropZonePartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendDropZone getComponent();
}
