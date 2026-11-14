package dev.reuise.web.frontend.basecomponent;
import akasha.Attr;
import akasha.CSSRuleList;
import akasha.CSSStyleDeclaration;
import akasha.CSSStyleSheet;
import akasha.Console;
import akasha.DOMRect;
import akasha.DOMTokenList;
import akasha.Element;
import akasha.Event;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.HTMLStyleElement;
import akasha.NamedNodeMap;
import akasha.ResizeObserver;
import akasha.WindowGlobal;
import akasha.core.JSON;
import akasha.svg.SVGElement;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.logging.impl.StackTracePrintStream;
import dev.reuise.core.ComponentUtils;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.HtmlEscaper;
import dev.reuise.core.LinkUrlResolverState;
import dev.reuise.core.LocaleContext;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.ScreenSizeValues;
import dev.reuise.core.State;
import dev.reuise.core.event.EventType;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.parentcomponent.CoreParentComponent;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.basecomponent.DefaultWebBaseComponentPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.style.StyleAdapter;
import dev.reuise.web.frontend.style.WebFrontendStyleSheet;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
public abstract class DefaultWebFrontendBaseComponent<S extends DefaultWebFrontendBaseComponent<S, O>, O extends WebFrontendBaseComponentOptions> extends DefaultWebBaseComponentPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendBaseComponent {
    private Element element;

    private ElementProvider elementProvider;

    private String baseStyleClass;

    private Style styleAdapter;

    private Style computedStyle;

    private boolean resizeEvents;

    private ResizeObserver resizeObserver;

    private boolean linkUrlResolverListening;

    private boolean linkUrlResolverWasActive;

    private boolean preserveHydratedHref;

    // True when this component's style class/element is shared with at least one other,
    // unrelated component instance (the backend deduplicated identical CSS across them). Reset
    // to false the first time a runtime style mutation forks this component onto a private
    // class/element - see forkStyleIfShared().
    private boolean styleShared;

    @Override
    public WebFrontendBaseComponent getComponent() {
        return ((WebFrontendBaseComponent) (super.getComponent()));
    }

    @Override
    public ElementProvider getElementProvider() {
        return elementProvider;
    }

    @Override
    public S setElementProvider(ElementProvider elementProvider) {
        Objects.requireNonNull(elementProvider, "Element provider is required");
        if ((element != null) && (this.elementProvider != elementProvider))
            throw new UnsupportedOperationException("Configure the element provider on options before creating the component");

        this.elementProvider = elementProvider;
        return self();
    }

    @Override
    public String getUniqueId() {
        if (uniqueId == null)
            uniqueId = "reuise_F" + ComponentUtils.generateRandomString();

        return uniqueId;
    }

    @Override
    public String getUniqueStyleClass() {
        if (uniqueStyleClass == null)
            uniqueStyleClass = "reuise-style_F" + ComponentUtils.generateRandomString();

        return uniqueStyleClass;
    }

    @Override
    public S setId(String id) {
        if (id == null)
            return self();

        element.id = id;
        return self();
    }

    @Override
    public S setBaseStyleClass(String baseStyleClass) {
        if (baseStyleClass == null)
            return self();

        this.baseStyleClass = baseStyleClass;
        element.className = baseStyleClass;
        return self();
    }

    @Override
    public S setStyleClasses(List<String> styleClasses) {
        if ((styleClasses == null) || styleClasses.isEmpty())
            return self();

        styleClasses.stream().forEach(c -> getElement().classList().add(c));
        return self();
    }

    @Override
    public S setRehydration(Element element) {
        if ((element != null) && (this.element == element))
            return self();

        throw new UnsupportedOperationException("Configure rehydration on options before creating the component");
    }

    @Override
    public S setRehydration(String selector) {
        if (element != null) {
            if (Objects.equals(rehydration, selector))
                return self();

            throw new UnsupportedOperationException("Configure rehydration on options before creating the component");
        }
        return super.setRehydration(selector);
    }

    @Override
    public S setRehydration(String selector, CoreComponent parent, Boolean canFail) {
        if (element != null)
            throw new UnsupportedOperationException("Configure rehydration on options before creating the component");

        return super.setRehydration(selector, parent, canFail);
    }

    // All of a component's states now share a single style class/element, so there is no
    // longer a per-state suffix to match: any existing "reuise-style_" class on the element is
    // the one to reuse, regardless of which state is currently being resolved.
    private String getExistingUniqueStyleClass() {
        DOMTokenList classes = element.classList();
        for (int c = 0; c < element.classList().length(); c++) {
            String className = classes.item(c);
            if ((className == null) || (!className.startsWith("reuise-style_")))
                continue;

            return className;
        }
        return null;
    }

    // Forks this component off a shared, deduplicated style class/element onto a brand new
    // private one, cloning the combined CSS so the component's existing appearance is
    // unaffected. Runs lazily, once, the first time a runtime style mutation actually occurs on
    // a component whose class is shared with other instances (see WebFrontendStyleSheetImpl's
    // fork callback hook).
    private void forkStyleIfShared() {
        if (!styleShared)
            return;

        Collection<StyleSheet> sheets = styles.getStyleSheets();
        HTMLStyleElement oldEl = null;
        for (StyleSheet s : sheets) {
            if (s instanceof WebFrontendStyleSheet wfs) {
                oldEl = wfs.getElement();
                break;
            }
        }
        if (oldEl == null) {
            styleShared = false;
            return;
        }
        String oldClass = this.uniqueStyleClass;
        String newClass = "reuise-style_F" + ComponentUtils.generateRandomString();
        HTMLStyleElement newEl = ((HTMLStyleElement) (WindowGlobal.document().createElement("style")));
        newEl.id = newClass;
        newEl.type = "text/css";
        WindowGlobal.document().head().appendChild(newEl);
        CSSStyleSheet oldSheet = oldEl.sheet();
        CSSStyleSheet newSheet = newEl.sheet();
        if ((oldSheet != null) && (newSheet != null)) {
            CSSRuleList cssRules = oldSheet.cssRules();
            for (int r = 0; r < cssRules.length(); r++) {
                String ruleText = cssRules.item(r).cssText.replace("." + oldClass, "." + newClass);
                newSheet.insertRule(ruleText);
            }
        }
        removeStyleClass(oldClass);
        this.uniqueStyleClass = newClass;
        addStyleClass(newClass);
        for (StyleSheet s : sheets) {
            if (s instanceof WebFrontendStyleSheet wfs) {
                wfs.reassignForkedElement(newEl);
                wfs.setShared(false);
            }
        }
        styleShared = false;
    }

    private HTMLElement createOrRehydrateElement(String tagName, String selector, boolean append) {
        boolean hasSelector = selector != null;
        if (isRehydrated())
            return ((HTMLElement) (element.querySelector(hasSelector ? selector : tagName)));
        else {
            HTMLElement el = ((HTMLElement) (WindowGlobal.document().createElement(tagName)));
            if (hasSelector) {
                if (selector.startsWith("."))
                    el.className = selector.substring(1);
                else if (selector.startsWith("#"))
                    el.id = selector.substring(1);

            }
            if (append)
                element.appendChild(el);

            return el;
        }
    }

    @Override
    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        getElement().classList().toggle(styleClass, add);
        return self();
    }

    @Override
    public S removeStyleClass(String styleCls) {
        getElement().classList().remove(styleCls);
        return self();
    }

    @Override
    public S setInlineStyle(Style style) {
        styleAdapter = style;
        return self();
    }

    @Override
    public Style getInlineStyle() {
        return styleAdapter;
    }

    @Override
    public String getId() {
        return element.id;
    }

    @Override
    public String getTooltip() {
        return element.getAttribute("title");
    }

    @Override
    public S setTooltip(String tooltip) {
        if (tooltip == null)
            element.removeAttribute("title");
        else
            element.setAttribute("title", tooltip);

        return self();
    }

    @Override
    public String getBaseStyleClass() {
        return baseStyleClass;
    }

    @Override
    public List<String> getStyleClasses() {
        List<String> classes = new ArrayList<>();
        DOMTokenList tokens = element.classList();
        for (int i = 0; i < tokens.length(); i++)
            classes.add(tokens.item(i));

        return classes;
    }

    @Override
    public S addStyleClass(String styleClass) {
        element.classList().add(styleClass);
        return self();
    }

    @Override
    public boolean hasStyleClass(String styleClass) {
        return element.classList().contains(styleClass);
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        NamedNodeMap domAttributes = element.attributes();
        for (int i = 0; i < domAttributes.length(); i++) {
            Attr attribute = domAttributes.item(i);
            attributes.put(attribute.name(), attribute.value);
        }
        return attributes;
    }

    @Override
    public S setAttributes(Map<String, String> attributes) {
        attributes.forEach(this::setAttribute);
        return self();
    }

    @Override
    public S setAttribute(String attribute, String value) {
        HtmlEscaper.attributeName(attribute);
        if ("href".equalsIgnoreCase(attribute) && LinkUrlResolverState.isNavigation(getComponent())) {
            String raw = (value == null) ? "" : value;
            HtmlEscaper.url(raw);
            LinkUrlResolverState state = ((LinkUrlResolverState) (this));
            if ((preserveHydratedHref && (state.getLinkUrlResolver() == null)) && raw.equals(element.getAttribute(LinkUrlResolverState.ORIGINAL_HREF))) {
                preserveHydratedHref = false;
                return self();
            }
            preserveHydratedHref = false;
            String resolved = LinkUrlResolverState.resolve(state, raw);
            element.setAttribute(LinkUrlResolverState.ORIGINAL_HREF, raw);
            element.setAttribute(attribute, resolved);
            linkUrlResolverWasActive = state.getLinkUrlResolver() != null;
            listenForLinkUrlResolver();
            return self();
        }
        element.setAttribute(attribute, value == null ? "" : value);
        return self();
    }

    private void listenForLinkUrlResolver() {
        if (linkUrlResolverListening)
            return;

        linkUrlResolverListening = true;
        ((LinkUrlResolverState) (this)).addLinkUrlResolverListener(this::refreshNavigationHref);
    }

    private void refreshNavigationHref() {
        String raw = element.getAttribute(LinkUrlResolverState.ORIGINAL_HREF);
        if (raw == null)
            return;

        LinkUrlResolverState state = ((LinkUrlResolverState) (this));
        boolean active = state.getLinkUrlResolver() != null;
        if ((!active) && (!linkUrlResolverWasActive))
            return;

        String resolved = LinkUrlResolverState.resolve(state, raw);
        if (!resolved.equals(element.getAttribute("href")))
            element.setAttribute("href", resolved);

        linkUrlResolverWasActive = active;
    }

    @Override
    public S removeAttribute(String attribute) {
        element.removeAttribute(attribute);
        if ("href".equalsIgnoreCase(attribute) && LinkUrlResolverState.isNavigation(getComponent()))
            element.removeAttribute(LinkUrlResolverState.ORIGINAL_HREF);

        return self();
    }

    @Override
    public String getAttribute(String attribute) {
        return element.getAttribute(attribute);
    }

    @Override
    public boolean hasAttribute(String attribute) {
        return element.hasAttribute(attribute);
    }

    @Override
    public S setStoreInElementOptions(List<String> options) {
        return self();
    }

    @Override
    public List<String> getStoreInElementOptions() {
        return null;
    }

    public S setFocused(Boolean focused) {
        HTMLElement htmlEl = getHtmlElement();
        if (Boolean.TRUE.equals(focused))
            htmlEl.focus();
        else
            htmlEl.blur();

        return self();
    }

    public boolean isFocused() {
        Element activeEl = WindowGlobal.document().activeElement();
        if (activeEl == null)
            return false;

        return activeEl == getElement();
    }

    @Override
    public void log(Object obj) {
        if (obj instanceof Throwable) {
            Throwable t = ((Throwable) (obj));
            StringBuilder message = new StringBuilder();
            StackTracePrintStream ps = new StackTracePrintStream(message);
            t.printStackTrace(ps);
            Console.log(message.toString());
        } else
            Console.log(obj);

    }

    protected CSSStyleDeclaration getElementStyle() {
        if (element instanceof HTMLElement)
            return ((HTMLElement) (element)).style();
        else if (element instanceof SVGElement)
            return ((SVGElement) (element)).style();

        return null;
    }

    @Override
    public Style getComputedStyle() {
        if (computedStyle == null)
            computedStyle = new StyleAdapter(WindowGlobal.getComputedStyle(element), null);

        return computedStyle;
    }

    @Override
    public S setResizeEventsEnabled(Boolean resizeEvents) {
        this.resizeEvents = resizeEvents;
        if (Boolean.FALSE.equals(resizeEvents) && (resizeObserver != null)) {
            resizeObserver.disconnect();
            return self();
        }
        if (resizeObserver == null)
            resizeObserver = new ResizeObserver((entries, observer) -> {
            });

        resizeObserver.observe(element);
        return self();
    }

    @Override
    public boolean isResizeEventsEnabled() {
        return resizeEvents;
    }

    @Override
    public void removeFromParent() {
        if (getParent() instanceof CoreParentComponent) {
            ((CoreParentComponent) (getParent())).remove(getComponent());
            return;
        }
        Element parentEl = element.parentElement();
        if (parentEl != null)
            parentEl.removeChild(element);

    }

    public static void runAsync(Runnable onSuccess, Consumer<Throwable> onFailure) {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onSuccess() {
                onSuccess.run();
            }

            @Override
            public void onFailure(Throwable e) {
                onFailure.accept(e);
            }
        });
    }

    protected ElementDataParser elementDataParser;

    protected Boolean requiredLayoutComponent;

    protected DefaultWebFrontendBaseComponent(O options) {
        super(options);
    }

    // Implementation
    // Implementation
    // Implementation
    public boolean onPreInitialize(O options) {
        if (!super.onPreInitialize(options))
            return false;

        try {
            elementProvider = Objects.requireNonNull(options.getElementProvider(), "Element provider is required");
            element = elementProvider.getElement(options);
            if (element == null) {
                if (isRehydrated())
                    isRehydrated = false;

                return false;
            }
            if ((isRehydrated() && LinkUrlResolverState.isNavigation(getComponent())) && element.hasAttribute("href")) {
                String original = element.getAttribute(LinkUrlResolverState.ORIGINAL_HREF);
                if (original == null) {
                    original = element.getAttribute("href");
                    element.setAttribute(LinkUrlResolverState.ORIGINAL_HREF, original);
                } else {
                    preserveHydratedHref = true;
                }
                listenForLinkUrlResolver();
                refreshNavigationHref();
            }
            String localeSnapshot = element.getAttribute("data-reuise-locale");
            if (localeSnapshot != null) {
                JsPropertyMap<Object> data = Js.asPropertyMap(JSON.parse(localeSnapshot));
                Map<String, String> snapshot = new LinkedHashMap<>();
                data.forEach(key -> {
                    Object value = data.get(key);
                    if (!(value instanceof String))
                        throw new IllegalArgumentException("Invalid locale snapshot value: " + key);

                    snapshot.put(key, ((String) (value)));
                });
                setLocaleContext(LocaleContext.fromSnapshot(snapshot));
            }
            setStyleSheetFactory(state -> {
                WebFrontendStyleSheet styleSheet = new WebFrontendStyleSheet(state);
                String existingUniqueStyleClass = getExistingUniqueStyleClass();
                if (existingUniqueStyleClass != null) {
                    this.uniqueStyleClass = existingUniqueStyleClass;
                    // A hydrated class already worn by more than one DOM element means the
                    // backend deduplicated this component's CSS with at least one other
                    // instance: any later runtime mutation must fork onto a private class first
                    // so it doesn't visually leak to the other instances sharing it.
                    this.styleShared = WindowGlobal.document().getElementsByClassName(existingUniqueStyleClass).length() > 1;
                }
                styleSheet.createOrRehydrate(getStyleSheetId());
                if (existingUniqueStyleClass == null)
                    styleSheet.insertBefore(getElement());

                if (!hasStyleClass(this.uniqueStyleClass))
                    addStyleClass(this.uniqueStyleClass);

                styleSheet.setShared(styleShared);
                styleSheet.setForkCallback(this::forkStyleIfShared);
                return styleSheet;
            });
            if (isRehydrated()) {
                options.rehydrate(element);
                ElementDataParser elDataParser = options.getElementDataParser();
                if (elDataParser != null) {
                    options.getStoreInElementOptions().forEach(o -> {
                        Object value = elDataParser.parse(o, getData(o));
                        if (value != null)
                            options.setOption(o, value);

                    });
                }
                if (element.parentElement() == null)
                    addStyleClass("reuise-rehydrating");
                else
                    addStyleClass("reuise-rehydrated");

            }
            baseStyleClass = options.getBaseStyleClass();
            setInlineStyle(new StyleAdapter(getElementStyle(), isRehydrated() ? null : options.getInlineStyle()));
        } catch (RehydrationFailedException e) {
            isRehydrated = false;
            Console.error(e.getMessage());
            Console.error("Selector: " + e.getSelector());
            Console.error(e.getParent());
        }
        return true;
    }

    public void onInitialize(O options) {
        super.onInitialize(options);
    }

    public void onCreate(O options) {
        super.onCreate(options);
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
        WebFrontendBaseComponentPart component = ((WebFrontendBaseComponentPart) (options.getComponent()));
        if (component == null)
            System.out.println("component is null");

        // Apply options for default state
        applicator.add(options.getElementProviderOption(), component::setElementProvider);
        applicator.add(options.getElementDataParserOption(), component::setElementDataParser);
        applicator.add(options.getResizeEventsEnabledOption(), component::setResizeEventsEnabled);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    @Override
    public WebFrontendComponentFactory getComponentFactory() {
        return ((WebFrontendComponentFactory) (super.getComponentFactory()));
    }

    @Override
    public ElementDataParser getElementDataParser() {
        return elementDataParser;
    }

    @Override
    public S setElementDataParser(ElementDataParser elementDataParser) {
        this.elementDataParser = elementDataParser;
        return self();
    }

    // Implementation
    @Override
    public S setStyleClass(String styleClass) {
        if ((baseStyleClass != null) && (!baseStyleClass.isEmpty()))
            getElement().className = baseStyleClass;

        return super.setStyleClass(styleClass);
    }

    @Override
    public S setStyleClasses(String... styleClasses) {
        setStyleClasses(new ArrayList<String>(Arrays.asList(styleClasses)));
        return self();
    }

    @Override
    public S setStyleAllStates(Style style) {
        setStyle(ScreenSizeValues.of(style, style));
        setStyle(style);
        return self();
    }

    // Implementation
    @Override
    public S setStoreInElementOptions(String storeInElementOptions) {
        return self();
    }

    @Override
    public S setMarginAllStates(Object margin) {
        setMargin(ScreenSizeValues.of(margin, margin));
        setMargin(margin);
        return self();
    }

    @Override
    public S setMarginTopAllStates(Object marginTop) {
        setMarginTop(ScreenSizeValues.of(marginTop, marginTop));
        setMarginTop(marginTop);
        return self();
    }

    @Override
    public S setMarginRightAllStates(Object marginRight) {
        setMarginRight(ScreenSizeValues.of(marginRight, marginRight));
        setMarginRight(marginRight);
        return self();
    }

    @Override
    public S setMarginBottomAllStates(Object marginBottom) {
        setMarginBottom(ScreenSizeValues.of(marginBottom, marginBottom));
        setMarginBottom(marginBottom);
        return self();
    }

    @Override
    public S setMarginLeftAllStates(Object marginLeft) {
        setMarginLeft(ScreenSizeValues.of(marginLeft, marginLeft));
        setMarginLeft(marginLeft);
        return self();
    }

    @Override
    public S setWidthAllStates(Object width) {
        setWidth(ScreenSizeValues.of(width, width));
        setWidth(width);
        return self();
    }

    @Override
    public S setMinWidthAllStates(Object minWidth) {
        setMinWidth(ScreenSizeValues.of(minWidth, minWidth));
        setMinWidth(minWidth);
        return self();
    }

    @Override
    public S setMaxWidthAllStates(Object maxWidth) {
        setMaxWidth(ScreenSizeValues.of(maxWidth, maxWidth));
        setMaxWidth(maxWidth);
        return self();
    }

    @Override
    public S setHeightAllStates(Object height) {
        setHeight(ScreenSizeValues.of(height, height));
        setHeight(height);
        return self();
    }

    @Override
    public S setMinHeightAllStates(Object minHeight) {
        setMinHeight(ScreenSizeValues.of(minHeight, minHeight));
        setMinHeight(minHeight);
        return self();
    }

    @Override
    public S setMaxHeightAllStates(Object maxHeight) {
        setMaxHeight(ScreenSizeValues.of(maxHeight, maxHeight));
        setMaxHeight(maxHeight);
        return self();
    }

    @Override
    public boolean isRequiredLayoutComponent() {
        return Boolean.TRUE.equals(requiredLayoutComponent);
    }

    @Override
    public S setRequiredLayoutComponent(Boolean requiredLayoutComponent) {
        this.requiredLayoutComponent = requiredLayoutComponent;
        return self();
    }

    @Override
    public S setVisibleAllStates(Boolean visible) {
        setVisible(ScreenSizeValues.of(visible, visible));
        setVisible(visible);
        return self();
    }

    // Implementation
    public Element getElement() {
        return element;
    }

    // Implementation
    public HTMLElement getHtmlElement() {
        return ((HTMLElement) (element));
    }

    // Implementation
    public Rect getBoundingBox() {
        DOMRect domRect = element.getBoundingClientRect();
        return new Rect(domRect.x(), domRect.y(), domRect.width(), domRect.height());
    }

    // Implementation
    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return createOrRehydrateElement(tagName, selector, true);
    }

    // Implementation
    public S on(EventType type, EventListener listener) {
        if (type == null)
            return self();

        element.addEventListener(type.getTypeName().trim(), listener);
        return self();
    }

    // Implementation
    public S on(Set<EventType> types, EventListener listener) {
        if (types == null)
            return self();

        types.stream().forEach(t -> on(t, listener));
        return self();
    }

    // Implementation
    public void dispatchEvent(EventType type) {
        if (type == null)
            return;

        element.dispatchEvent(new Event(type.getTypeName()));
    }

    // Implementation
    public void click() {
        getHtmlElement().click();
    }
}
