package dev.reuise.web.frontend.chip;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.web.core.chip.WebFilterChipPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendFilterChipPartOptions extends WebFilterChipPartOptions {
    WebFrontendChipPartOptions getChipPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendFilterChip getComponent();
}
