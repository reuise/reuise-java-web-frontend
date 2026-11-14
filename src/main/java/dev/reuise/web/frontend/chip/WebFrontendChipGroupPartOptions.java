package dev.reuise.web.frontend.chip;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.chip.WebChipGroupPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendFieldSetPartOptions;
public interface WebFrontendChipGroupPartOptions extends WebChipGroupPartOptions {
    WebFrontendFieldSetPartOptions getFieldSetPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendChipGroupPartOptions setAddButtonCreator(ComponentCreator<? extends WebFrontendChip, ? extends WebFrontendChipOptions> addButtonCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendChipGroup getComponent();
}
