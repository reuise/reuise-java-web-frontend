package dev.reuise.web.frontend.input;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.input.WebChipFieldPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.chip.WebFrontendChipGroup;
import dev.reuise.web.frontend.chip.WebFrontendChipGroupOptions;
public interface WebFrontendChipFieldPartOptions extends WebChipFieldPartOptions {
    WebFrontendTextFieldPartOptions getTextFieldPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendChipFieldPartOptions setChipGroupCreator(ComponentCreator<? extends WebFrontendChipGroup, ? extends WebFrontendChipGroupOptions> chipGroupCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendChipField getComponent();
}
