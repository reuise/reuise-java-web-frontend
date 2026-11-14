package dev.reuise.web.frontend.document;
import akasha.Element;
import akasha.Event;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.MediaQueryList;
import akasha.URLSearchParams;
import akasha.WindowGlobal;
import akasha.lang.JsIIterableResult;
import akasha.lang.JsIterator;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.LocaleContext;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.ScreenSize;
import dev.reuise.core.State;
import dev.reuise.core.TextDirection;
import dev.reuise.core.event.EventType;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.parentcomponent.CoreParentComponentOptions;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.document.DefaultWebDocumentPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.style.WebFrontendStyleSheet;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheet;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
// Option: Children - CORE
// Option: ElementProvider - WEB_FRONTEND
// Option: ElementDataParser - WEB_FRONTEND
// Option: ResizeEventsEnabled - WEB_FRONTEND
// Option: Id - WEB
// Option: TagName - WEB
// Option: XmlNamespace - WEB
// Option: Tooltip - WEB
// Option: BaseStyleClass - WEB
// Option: Attributes - WEB
// Option: StyleClasses - WEB
// Option: Data - WEB
// Option: Style - WEB
// Option: InlineStyle - WEB
// Option: Rehydration - WEB
// Option: ContentEditable - WEB
// Option: StoreInElementOptions - WEB
// Option: Mounted - CORE
// Option: Margin - CORE
// Option: MarginTop - CORE
// Option: MarginRight - CORE
// Option: MarginBottom - CORE
// Option: MarginLeft - CORE
// Option: Width - CORE
// Option: MinWidth - CORE
// Option: MaxWidth - CORE
// Option: Height - CORE
// Option: MinHeight - CORE
// Option: MaxHeight - CORE
// Option: RequiredLayoutComponent - CORE
// Option: Parent - CORE
// Option: LocaleContext - CORE
// Option: LinkUrlResolver - CORE
// Option: Wrapper - CORE
// Option: Theme - CORE
// Option: Visible - CORE
// Option: Enabled - CORE
// Option: Focused - CORE
// Option: Debug - CORE
// Option: DebugId - CORE
// base comp: parentComponent
// base comp: baseComponent
// add composition for baseComponent: getElement
// add composition for baseComponent: getHtmlElement
// add composition for baseComponent: getBoundingBox
// add composition for baseComponent: createOrRehydrateElement
// add composition for baseComponent: on
// add composition for baseComponent: on
// add composition for baseComponent: dispatchEvent
// add composition for baseComponent: click
// add composition for baseComponent: isRehydrated
// add composition for baseComponent: getComputedStyle
// add composition for baseComponent: addOrRemoveStyleClass
// add composition for baseComponent: hasStyleClass
// add composition for baseComponent: removeStyleClass
// add composition for baseComponent: setAttribute
// add composition for baseComponent: removeAttribute
// add composition for baseComponent: getAttribute
// add composition for baseComponent: hasAttribute
// add composition for baseComponent: setData
// add composition for baseComponent: getData
// add composition for baseComponent: hasData
// add composition for baseComponent: setAria
// add composition for baseComponent: getAria
// add composition for baseComponent: hasAria
// add composition for baseComponent: getUniqueId
// add composition for baseComponent: getUniqueStyleClass
// add composition for baseComponent: getStyleSheetId
// add composition for baseComponent: getStyleStates
// add composition for baseComponent: setStyleSheetFactory
// add composition for baseComponent: getStyle
// add composition for baseComponent: hasWrapper
// add composition for baseComponent: isInitialized
// add composition for baseComponent: log
// add composition for baseComponent: removeFromParent
public abstract class DefaultWebFrontendDocument<S extends DefaultWebFrontendDocument<S, O>, O extends WebFrontendDocumentOptions> extends DefaultWebDocumentPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendDocument {
    private ScreenSize screenSize;

    private String currentHref;

    protected void onLoad() {
    }

    private void setUpMediaListener(ScreenSize screenSize) {
        MediaQueryList mediaQueryList = WindowGlobal.matchMedia(screenSize.getQuery());
        if (mediaQueryList.matches())
            setScreenSizeBodyClass(screenSize);

        mediaQueryList.addEventListener("change", e -> {
            if (((MediaQueryList) (e.target())).matches())
                setScreenSizeBodyClass(screenSize);

        });
    }

    private void setScreenSizeBodyClass(ScreenSize screenSize) {
        if (this.screenSize != null)
            addOrRemoveStyleClass(getScreenSizeClassName(this.screenSize), false);

        addOrRemoveStyleClass(getScreenSizeClassName(screenSize), true);
        this.screenSize = screenSize;
    }

    private String getScreenSizeClassName(ScreenSize screenSize) {
        return "reuise-document--" + screenSize.getShortName();
    }

    private void checkScrolled(Event e) {
        addOrRemoveStyleClass("reuise-document--scrolled", WindowGlobal.document().documentElement().scrollTop > 10);
    }

    @Override
    public String getTitle() {
        return WindowGlobal.document().title;
    }

    @Override
    public S setTitle(String title) {
        WindowGlobal.document().title = title;
        return self();
    }

    @Override
    public String getViewId() {
        String viewId = body.getData("viewid");
        if ((viewId != null) && (!viewId.isEmpty()))
            return viewId;

        return JsWindow.reuiseViewId;
    }

    @Override
    public S setViewId(String viewId) {
        body.setData("viewid", viewId);
        return self();
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public S setDescription(String description) {
        return self();
    }

    @Override
    public boolean hasKeyword(String keyword) {
        return false;
    }

    @Override
    public S addKeyword(String keyword) {
        return self();
    }

    @Override
    public List<String> getKeywords() {
        return null;
    }

    @Override
    public S removeKeyword(String keyword) {
        return self();
    }

    @Override
    public S clearKeywords() {
        return self();
    }

    @Override
    public S setKeywords(List<String> keywords) {
        return self();
    }

    @Override
    public String getThemeColor() {
        return null;
    }

    @Override
    public S setThemeColor(String themeColor) {
        return self();
    }

    @Override
    public String getLanguage() {
        return WindowGlobal.document().documentElement().getAttribute("lang");
    }

    @Override
    public S setLanguage(String language) {
        if (language != null)
            setLocaleContext(getLocaleContext().withLanguageTag(language));

        return self();
    }

    public TextDirection getTextDirection() {
        String direction = WindowGlobal.document().documentElement().getAttribute("dir");
        if ("ltr".equals(direction))
            return TextDirection.LTR;

        if ("rtl".equals(direction))
            return TextDirection.RTL;

        if ("auto".equals(direction))
            return TextDirection.AUTO;

        return null;
    }

    public S setTextDirection(TextDirection textDirection) {
        setLocaleContext(getLocaleContext().withTextDirection(textDirection));
        return self();
    }

    @Override
    public String getCharset() {
        return null;
    }

    @Override
    public S setCharset(String charset) {
        return self();
    }

    @Override
    public String getUrl() {
        return WindowGlobal.document().location().href;
    }

    @Override
    public S setUrl(String url) {
        WindowGlobal.document().location().href = url;
        return self();
    }

    @Override
    public String getPath() {
        return WindowGlobal.document().location().pathname;
    }

    @Override
    public S setPath(String path) {
        WindowGlobal.document().location().pathname = path;
        return self();
    }

    @Override
    public Map<String, Object> getModel() {
        return null;
    }

    @Override
    public S setModel(Map<String, Object> model) {
        return self();
    }

    @Override
    public String getUrlParameter(String urlParameter) {
        URLSearchParams searchParams = new URLSearchParams(WindowGlobal.location().search);
        return searchParams.get(urlParameter);
    }

    @Override
    public Map<String, String> getUrlParameters() {
        Map<String, String> parameters = new HashMap<>();
        URLSearchParams searchParams = new URLSearchParams(WindowGlobal.location().search);
        JsIterator<URLSearchParams.Entry> entries = searchParams.entries();
        JsIIterableResult<URLSearchParams.Entry> result = entries.next();
        while (!result.isDone()) {
            parameters.put(result.getValue().key(), result.getValue().value());
            result = entries.next();
        } 
        return parameters;
    }

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendDocument(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        parentComponentPart = options.getComponentFactory().createParentComponent(((CoreParentComponentOptions) (options.getParentComponentPart())));
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, parentComponentPart);
        commonStyles.setStyleSheetFactory(state -> {
            WebFrontendStyleSheet styleSheet = new WebFrontendStyleSheet(state);
            styleSheet.createOrRehydrate("reuise-commonstyles" + (state != null ? "_" + state.getStateKey() : ""));
            styleSheet.appendToHead();
            return styleSheet;
        });
    }

    public WebFrontendParentComponentPart getParentComponentPart() {
        return parentComponentPart;
    }

    // Implementation
    @Override
    public RootComponent getRootComponent() {
        return ((RootComponent) (getComponent()));
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.parentComponentPart.setRootComponent(rootComponent);
        if (body != null)
            body.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return parentComponentPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (body != null)
            body.setTheme(theme);

        this.parentComponentPart.setTheme(theme);
        return self();
    }

    @Override
    public ElementProvider getElementProvider() {
        return baseComponentPart.getElementProvider();
    }

    @Override
    public S setElementProvider(ElementProvider elementProvider) {
        this.baseComponentPart.setElementProvider(elementProvider);
        return self();
    }

    @Override
    public ElementDataParser getElementDataParser() {
        return baseComponentPart.getElementDataParser();
    }

    @Override
    public S setElementDataParser(ElementDataParser elementDataParser) {
        this.baseComponentPart.setElementDataParser(elementDataParser);
        return self();
    }

    @Override
    public boolean isResizeEventsEnabled() {
        return baseComponentPart.isResizeEventsEnabled();
    }

    @Override
    public S setResizeEventsEnabled(Boolean resizeEventsEnabled) {
        this.baseComponentPart.setResizeEventsEnabled(resizeEventsEnabled);
        return self();
    }

    @Override
    public S setRehydration(Element element) {
        this.baseComponentPart.setRehydration(element);
        return self();
    }

    @Override
    public S setRehydration(String rehydration, Boolean canFail) {
        this.baseComponentPart.setRehydration(rehydration, canFail);
        return self();
    }

    @Override
    public S setRehydration(String selector, CoreComponent parent) {
        this.baseComponentPart.setRehydration(selector, parent);
        return self();
    }

    @Override
    public S setRehydration(String selector, CoreComponent parent, Boolean canFail) {
        this.baseComponentPart.setRehydration(selector, parent, canFail);
        return self();
    }

    public Element getElement() {
        return parentComponentPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return parentComponentPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return parentComponentPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return parentComponentPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        parentComponentPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        parentComponentPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        parentComponentPart.dispatchEvent(type);
    }

    public void click() {
        parentComponentPart.click();
    }

    public boolean isRehydrated() {
        if (parentComponentPart == null)
            return false;

        return parentComponentPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return parentComponentPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        parentComponentPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return parentComponentPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        parentComponentPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        parentComponentPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        parentComponentPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        parentComponentPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return parentComponentPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return parentComponentPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        parentComponentPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return parentComponentPart.getData(data);
    }

    public boolean hasData(String data) {
        return parentComponentPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        parentComponentPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return parentComponentPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return parentComponentPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return parentComponentPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return parentComponentPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return parentComponentPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return parentComponentPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return parentComponentPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        parentComponentPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return parentComponentPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return parentComponentPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return parentComponentPart.hasWrapper();
    }

    public boolean isInitialized() {
        return parentComponentPart.isInitialized();
    }

    public void log(Object obj) {
        parentComponentPart.log(obj);
    }

    public void removeFromParent() {
        parentComponentPart.removeFromParent();
    }

    @Override
    public WebFrontendComponentFactory getComponentFactory() {
        return ((WebFrontendComponentFactory) (baseComponentPart.getComponentFactory()));
    }

    public WebFrontendBaseComponentPart getBaseComponentPart() {
        return baseComponentPart;
    }

    @Override
    public void addPart(ComponentPart.Type type, ComponentPart part) {
        baseComponentPart.addPart(type, part);
    }

    @Override
    public <C extends ComponentType<?, T>, T extends CoreComponentOptions> void initialize(C component, T options) {
        setupReferences();
        baseComponentPart.initialize(component, options);
    }

    @Override
    public WebFrontendDocument getComponent() {
        return ((WebFrontendDocument) (baseComponentPart.getComponent()));
    }

    // Implementation
    // Implementation
    // Implementation
    public boolean onPreInitialize(O options) {
        if ((getAttribute("data-reuise-locale") == null) && (options.getLocaleContext() == null)) {
            String language = getLanguage();
            if ((language != null) && (!language.isEmpty()))
                setLocaleContext(new LocaleContext(language).withTextDirection(getTextDirection()));

        }
        return super.onPreInitialize(options);
    }

    @Override
    public S rehydrate(CoreComponent child) {
        ((WebFrontendDocumentBodyPart) (getBody())).rehydrate(child);
        return self();
    }

    // Implementation
    // Implementation
    // Implementation
    public void onInitialize(O options) {
        super.onInitialize(options);
        WindowGlobal.addEventListener("scroll", this::checkScrolled);
        checkScrolled(null);
        for (ScreenSize screenSize : ScreenSize.values())
            setUpMediaListener(screenSize);

        currentHref = WindowGlobal.document().location().href;
        WindowGlobal.addEventListener("popstate", e -> {
            String newHref = WindowGlobal.document().location().href;
            if (!newHref.equals(currentHref)) {
                // Todo fire event
                currentHref = newHref;
            }
        });
        onLoad();
    }

    public void onCreate(O options) {
        super.onCreate(options);
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        parentComponentPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendDocumentBody getBody() {
        return ((WebFrontendDocumentBody) (super.getBody()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    @Override
    public S setStyleSheet(StyleSheet styleSheet) {
        setStyleSheet(new ArrayList<StyleSheet>(Arrays.asList(styleSheet)));
        return self();
    }
}
