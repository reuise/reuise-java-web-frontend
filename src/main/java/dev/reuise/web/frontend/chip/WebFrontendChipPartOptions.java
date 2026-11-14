package dev.reuise.web.frontend.chip;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.chip.WebChipPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPartOptions;
import dev.reuise.web.frontend.text.WebFrontendLabel;
import dev.reuise.web.frontend.text.WebFrontendLabelOptions;
public interface WebFrontendChipPartOptions extends WebChipPartOptions {
    WebFrontendParentComponentPartOptions getParentComponentPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendChipPartOptions setStartIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> startIconCreator);

    WebFrontendChipPartOptions setLabelContainerCreator(ComponentCreator<? extends WebFrontendLabel, ? extends WebFrontendLabelOptions> labelContainerCreator);

    WebFrontendChipPartOptions setEndIconCreator(ComponentCreator<? extends WebFrontendIcon, ? extends WebFrontendIconOptions> endIconCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendChip getComponent();
}
