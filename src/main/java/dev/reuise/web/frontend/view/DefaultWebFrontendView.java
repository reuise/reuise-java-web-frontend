package dev.reuise.web.frontend.view;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.TimerHandler;
import akasha.URLSearchParams;
import akasha.WindowGlobal;
import akasha.lang.JsIIterableResult;
import akasha.lang.JsIterator;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.State;
import dev.reuise.core.event.EventType;
import dev.reuise.core.layout.BackdropFilter;
import dev.reuise.core.layout.CoreFlexContainerOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.view.DefaultWebViewPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.Navigator;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// Option: Direction - CORE
// Option: JustifyContent - CORE
// Option: AlignItems - CORE
// Option: ColumnGap - CORE
// Option: RowGap - CORE
// Option: Gap - CORE
// Option: Wrap - CORE
// Option: Animation - WEB
// Option: Padding - CORE
// Option: PaddingTop - CORE
// Option: PaddingRight - CORE
// Option: PaddingBottom - CORE
// Option: PaddingLeft - CORE
// Option: Position - CORE
// Option: Inset - CORE
// Option: BackdropFilter - CORE
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
// base comp: flexContainer
// base comp: container
// add composition for container: startAnimation
// add composition for container: cancelAnimation
// add composition for container: addMarkdown
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
public abstract class DefaultWebFrontendView<S extends DefaultWebFrontendView<S, O>, O extends WebFrontendViewOptions> extends DefaultWebViewPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendView {
    @Override
    public String getParameter(String parameter) {
        URLSearchParams searchParams = new URLSearchParams(WindowGlobal.location().search);
        return searchParams.get(parameter);
    }

    @Override
    public Map<String, String> getParameters() {
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

    public int setTimeout(TimerHandler handler) {
        return WindowGlobal.setTimeout(handler);
    }

    public int setInterval(TimerHandler handler) {
        return WindowGlobal.setInterval(handler);
    }

    public S setUrl(String url) {
        Navigator.updateUrl(url);
        return self();
    }

    public String getUrl() {
        return WindowGlobal.location().href;
    }

    public String getContentType() {
        return "text/html";
    }

    protected final WebFrontendFlexContainerPart flexContainerPart;

    protected final WebFrontendContainerPart containerPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendView(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        flexContainerPart = options.getComponentFactory().createFlexContainer(((CoreFlexContainerOptions) (options.getFlexContainerPart())));
        containerPart = flexContainerPart.getContainerPart();
        parentComponentPart = containerPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, flexContainerPart);
    }

    public WebFrontendFlexContainerPart getFlexContainerPart() {
        return flexContainerPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return flexContainerPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.flexContainerPart.setRootComponent(rootComponent);
    }

    @Override
    public Theme getTheme() {
        return flexContainerPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.flexContainerPart.setTheme(theme);
        return self();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.flexContainerPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(getRootComponent());
        return self();
    }

    @Override
    public S setBackdropFilter(BackdropFilter backdropFilter, Object value) {
        this.containerPart.setBackdropFilter(backdropFilter, value);
        return self();
    }

    public S startAnimation() {
        flexContainerPart.startAnimation();
        return self();
    }

    public S cancelAnimation() {
        flexContainerPart.cancelAnimation();
        return self();
    }

    public S addMarkdown(String markdown) {
        flexContainerPart.addMarkdown(markdown);
        return self();
    }

    public WebFrontendContainerPart getContainerPart() {
        return containerPart;
    }

    public WebFrontendParentComponentPart getParentComponentPart() {
        return parentComponentPart;
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
        return flexContainerPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return flexContainerPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return flexContainerPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return flexContainerPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        flexContainerPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        flexContainerPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        flexContainerPart.dispatchEvent(type);
    }

    public void click() {
        flexContainerPart.click();
    }

    public boolean isRehydrated() {
        if (flexContainerPart == null)
            return false;

        return flexContainerPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return flexContainerPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        flexContainerPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return flexContainerPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        flexContainerPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        flexContainerPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        flexContainerPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        flexContainerPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return flexContainerPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return flexContainerPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        flexContainerPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return flexContainerPart.getData(data);
    }

    public boolean hasData(String data) {
        return flexContainerPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        flexContainerPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return flexContainerPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return flexContainerPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return flexContainerPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return flexContainerPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return flexContainerPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return flexContainerPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return flexContainerPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        flexContainerPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return flexContainerPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return flexContainerPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return flexContainerPart.hasWrapper();
    }

    public boolean isInitialized() {
        return flexContainerPart.isInitialized();
    }

    public void log(Object obj) {
        flexContainerPart.log(obj);
    }

    public void removeFromParent() {
        flexContainerPart.removeFromParent();
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
    public WebFrontendView getComponent() {
        return ((WebFrontendView) (baseComponentPart.getComponent()));
    }

    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated())
            options.rehydrate(getElement());

        if (!super.onPreInitialize(options))
            return false;

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
        WebFrontendViewPart component = ((WebFrontendViewPart) (options.getComponent()));
        if (component == null)
            System.out.println("component is null");

        // Apply options for default state
        applicator.add(options.getUrlOption(), component::setUrl);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        flexContainerPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    // Implementation
    public int setTimeout(TimerHandler handler, int timeout) {
        return WindowGlobal.setTimeout(handler, timeout);
    }

    // Implementation
    public int setInterval(TimerHandler handler, int timeout) {
        return WindowGlobal.setInterval(handler, timeout);
    }

    // Implementation
    public S setDocumentTitle(String title) {
        WindowGlobal.document().title = title;
        return self();
    }

    // Implementation
    public String getDocumentTitle() {
        return WindowGlobal.document().title;
    }
}
