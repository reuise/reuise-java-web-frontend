package dev.reuise.web.frontend.basecomponent;
import akasha.Element;
import akasha.WindowGlobal;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.option.ComponentOption;
import dev.reuise.web.core.basecomponent.AbstractWebBaseComponentOptions;
import dev.reuise.web.frontend.DefaultElementProvider;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import java.util.ArrayList;
import java.util.Arrays;
public abstract class AbstractWebFrontendBaseComponentOptions<S extends AbstractWebFrontendBaseComponentOptions<S>> extends AbstractWebBaseComponentOptions<S> implements WebFrontendBaseComponentOptions {
    private Element rehydratedElement;

    public boolean isRehydrated() {
        if (rehydratedElement != null)
            return true;

        return super.isRehydrated();
    }

    @Override
    public S setRehydration(String selector) {
        rehydratedElement = null;
        super.setRehydration(selector);
        setElementProvider(new DefaultElementProvider((selector == null) || selector.isEmpty() ? null : selector));
        return self();
    }

    @Override
    public S setRehydration(String selector, CoreComponent parent) {
        super.setRehydration(selector, parent);
        setElementProvider(new DefaultElementProvider((selector == null) || selector.isEmpty() ? null : selector, parent != null ? ((WebFrontendComponent) (parent)).getElement() : WindowGlobal.document().body));
        return self();
    }

    @Override
    public S setRehydration(Element element) {
        super.setRehydration(((String) (null)));
        rehydratedElement = element;
        if (element == null)
            setElementProvider(new DefaultElementProvider());
        else
            setElementProvider(opts -> element);

        return self();
    }

    @Override
    public S setParent(CoreComponent parent) {
        super.setParent(parent);
        if (parent != null) {
            ElementProvider elProvider = getElementProvider();
            if (elProvider instanceof DefaultElementProvider) {
                DefaultElementProvider defElProvider = ((DefaultElementProvider) (elProvider));
                defElProvider.setParent(((WebFrontendComponent) (parent)).getElement());
            }
        }
        return self();
    }

    @Override
    public WebFrontendComponentFactory getComponentFactory() {
        return null;
    }

    protected AbstractWebFrontendBaseComponentOptions() {
        setElementDataParser((option, value) -> {
            String valueString = value;
            if ((valueString != null) && (!valueString.isEmpty())) {
                if (option.equals("debug"))
                    return Boolean.parseBoolean(valueString);

            }
            if (option.equals("debugid"))
                return value;

            return null;
        });
        setElementProvider(new DefaultElementProvider());
    }

    public <O extends CoreComponentOptions> void initialize(O options) {
        super.initialize(options);
    }

    public boolean onPreInitialize() {
        if (!super.onPreInitialize())
            return false;

        setStoreInElementOptions(new ArrayList(Arrays.asList("debug", "debugId")));
        return true;
    }

    public void onInitialize() {
        super.onInitialize();
    }

    @Override
    public ElementProvider getElementProvider() {
        return ((ElementProvider) (getOptionValue("elementProvider")));
    }

    @Override
    public ComponentOption<ElementProvider> getElementProviderOption() {
        return ((ComponentOption<ElementProvider>) (getOption("elementProvider")));
    }

    @Override
    public S setElementProvider(ElementProvider elementProvider) {
        setOption("elementProvider", elementProvider);
        return self();
    }

    private void setDefaultElementProvider(ElementProvider elementProvider) {
        setDefaultOption("elementProvider", elementProvider);
    }

    @Override
    public ElementDataParser getElementDataParser() {
        return ((ElementDataParser) (getOptionValue("elementDataParser")));
    }

    @Override
    public ComponentOption<ElementDataParser> getElementDataParserOption() {
        return ((ComponentOption<ElementDataParser>) (getOption("elementDataParser")));
    }

    @Override
    public S setElementDataParser(ElementDataParser elementDataParser) {
        setOption("elementDataParser", elementDataParser);
        return self();
    }

    private void setDefaultElementDataParser(ElementDataParser elementDataParser) {
        setDefaultOption("elementDataParser", elementDataParser);
    }

    @Override
    public boolean isResizeEventsEnabled() {
        return Boolean.TRUE.equals(getOptionValue("resizeEventsEnabled"));
    }

    @Override
    public ComponentOption<Boolean> getResizeEventsEnabledOption() {
        return ((ComponentOption<Boolean>) (getOption("resizeEventsEnabled")));
    }

    @Override
    public S setResizeEventsEnabled(Boolean resizeEventsEnabled) {
        setOption("resizeEventsEnabled", resizeEventsEnabled);
        return self();
    }

    private void setDefaultResizeEventsEnabled(Boolean resizeEventsEnabled) {
        setDefaultOption("resizeEventsEnabled", resizeEventsEnabled);
    }

    @Override
    public boolean rehydrate(Element element) {
        if (element == null)
            return false;

        setRehydration(element);
        // Todo: replace with storeinelementoptions
        if (getOption("debug") == null || getOption("debug") instanceof dev.reuise.core.option.DefaultComponentOption) {
            String debugString = element.getAttribute("data-debug");
            if ((debugString != null) && (!debugString.isEmpty()))
                setDebug(Boolean.parseBoolean(debugString));

            if (getOption("debug") != null && !(getOption("debug") instanceof dev.reuise.core.option.DefaultComponentOption)) getOptions().put("debug", dev.reuise.core.option.RehydratedComponentOption.from(getOption("debug")));
        }
        if (getOption("debugId") == null || getOption("debugId") instanceof dev.reuise.core.option.DefaultComponentOption) {
            String debugIdString = element.getAttribute("data-debugid");
            if ((debugIdString != null) && (!debugIdString.isEmpty()))
                setDebugId(debugIdString);

            if (getOption("debugId") != null && !(getOption("debugId") instanceof dev.reuise.core.option.DefaultComponentOption)) getOptions().put("debugId", dev.reuise.core.option.RehydratedComponentOption.from(getOption("debugId")));
        }
        return true;
    }

    public WebFrontendBaseComponent getComponent() {
        return ((WebFrontendBaseComponent) (super.getComponent()));
    }

    public void setComponent(WebFrontendBaseComponent component) {
    }
}
