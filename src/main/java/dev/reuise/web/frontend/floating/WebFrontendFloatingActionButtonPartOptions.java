package dev.reuise.web.frontend.floating;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.floating.WebFloatingActionButtonPartOptions;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.button.WebFrontendButtonPartOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
public interface WebFrontendFloatingActionButtonPartOptions extends WebFloatingActionButtonPartOptions {
    WebFrontendButtonPartOptions getButtonPart();

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendFloatingActionButtonPartOptions setBadgeCreator(ComponentCreator<? extends WebFrontendInlineText, ? extends WebFrontendInlineTextOptions> badgeCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendFloatingActionButton getComponent();
}
