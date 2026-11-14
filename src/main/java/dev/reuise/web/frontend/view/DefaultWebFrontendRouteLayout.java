package dev.reuise.web.frontend.view;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.WindowGlobal;
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
import dev.reuise.core.layout.CoreContainerOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebComponent;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.view.DefaultWebRouteLayoutPart;
import dev.reuise.web.core.view.RouteOptions;
import dev.reuise.web.core.view.RouteViewBeforeRevealHandler;
import dev.reuise.web.core.view.RouteViewRevealHandler;
import dev.reuise.web.core.view.RouteViewRevealOptions;
import dev.reuise.web.core.view.WebView;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.Navigator;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.DefaultWebFrontendBaseComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
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
public abstract class DefaultWebFrontendRouteLayout<S extends DefaultWebFrontendRouteLayout<S, O>, O extends WebFrontendRouteLayoutOptions> extends DefaultWebRouteLayoutPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendRouteLayout {
    private String currentHref;

    private String initialUrl;

    private boolean waitForSetRevealHandler = false;

    private boolean waitForSetBeforeRevealHandler = false;

    protected void createView(RouteOptions route, RouteViewRevealOptions revealOptions, Consumer<WebView> viewCallback) {
        if (route.isSplitCode()) {
            DefaultWebFrontendBaseComponent.runAsync(() -> super.createView(route, revealOptions, viewCallback), Throwable::printStackTrace);
        } else
            super.createView(route, revealOptions, viewCallback);

    }

    @Override
    protected void reveal(RouteViewRevealOptions revealOpts) {
        super.reveal(revealOpts);
        if (revealOpts == null)
            return;

        WebComponent view = revealOpts.getView();
        if (view instanceof WebView webView) {
            String title = webView.getTitle();
            if (title != null)
                WindowGlobal.document().title = title;

        }
    }

    private boolean hasFiredInitialReveal() {
        return initialUrl == null;
    }

    public S setUrl(String url, boolean updateUrl) {
        if (!hasFiredInitialReveal())
            return self();

        if (updateUrl)
            Navigator.updateUrl(url);
        else {
            super.setUrl(url);
        }
        return self();
    }

    @Override
    public void reveal(String url, boolean updateUrl) {
        if (updateUrl)
            Navigator.updateUrl(url);
        else
            super.reveal(url);

    }

    @Override
    public void reveal(String url) {
        reveal(url, false);
    }

    private void fireInitialReveal() {
        if (hasFiredInitialReveal())
            return;

        // if (waitForSetRevealHandler && revealHandlers != null && !revealHandlers.isEmpty())
        // return;
        if ((waitForSetBeforeRevealHandler && (beforeRevealHandlers != null)) && (!beforeRevealHandlers.isEmpty()))
            return;

        String url = initialUrl;
        initialUrl = null;
        reveal(url, revealHandlers, beforeRevealHandlers);
    }

    @Override
    public String getUrl() {
        return WindowGlobal.document().location().href;
    }

    public boolean isCurrentView(WebView view) {
        return currentView == view;
    }

    public S setRevealHandlers(List<RouteViewRevealHandler> revealHandlers) {
        super.setRevealHandlers(revealHandlers);
        fireInitialReveal();
        return self();
    }

    public S setBeforeRevealHandler(List<RouteViewBeforeRevealHandler> beforeRevealHandlers) {
        super.setBeforeRevealHandlers(beforeRevealHandlers);
        fireInitialReveal();
        return self();
    }

    protected final WebFrontendContainerPart containerPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected WebView currentView;

    protected DefaultWebFrontendRouteLayout(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        containerPart = options.getComponentFactory().createContainer(((CoreContainerOptions) (options.getContainerPart())));
        parentComponentPart = containerPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, containerPart);
    }

    @Override
    public S setBackdropFilter(BackdropFilter backdropFilter, Object value) {
        this.containerPart.setBackdropFilter(backdropFilter, value);
        return self();
    }

    public S startAnimation() {
        containerPart.startAnimation();
        return self();
    }

    public S cancelAnimation() {
        containerPart.cancelAnimation();
        return self();
    }

    public S addMarkdown(String markdown) {
        containerPart.addMarkdown(markdown);
        return self();
    }

    public WebFrontendContainerPart getContainerPart() {
        return containerPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return containerPart.getRootComponent();
    }

    // Implementation
    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.containerPart.setRootComponent(rootComponent);
        fireInitialReveal();
    }

    @Override
    public Theme getTheme() {
        return containerPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.containerPart.setTheme(theme);
        return self();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.containerPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(getRootComponent());
        return self();
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
        return containerPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return containerPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return containerPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return containerPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        containerPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        containerPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        containerPart.dispatchEvent(type);
    }

    public void click() {
        containerPart.click();
    }

    public boolean isRehydrated() {
        if (containerPart == null)
            return false;

        return containerPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return containerPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        containerPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return containerPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        containerPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        containerPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        containerPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        containerPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return containerPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return containerPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        containerPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return containerPart.getData(data);
    }

    public boolean hasData(String data) {
        return containerPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        containerPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return containerPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return containerPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return containerPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return containerPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return containerPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return containerPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return containerPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        containerPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return containerPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return containerPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return containerPart.hasWrapper();
    }

    public boolean isInitialized() {
        return containerPart.isInitialized();
    }

    public void log(Object obj) {
        containerPart.log(obj);
    }

    public void removeFromParent() {
        containerPart.removeFromParent();
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
    public WebFrontendRouteLayout getComponent() {
        return ((WebFrontendRouteLayout) (baseComponentPart.getComponent()));
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

    // Implementation
    // Implementation
    public void onCreate(O options) {
        super.onCreate(options);
        List<RouteViewRevealHandler> revealHandlers = options.getRevealHandlers();
        List<RouteViewBeforeRevealHandler> beforeRevealHandlers = options.getBeforeRevealHandlers();
        initialUrl = options.getUrl();
        waitForSetRevealHandler = (revealHandlers != null) && (!revealHandlers.isEmpty());
        waitForSetBeforeRevealHandler = (beforeRevealHandlers != null) && (!beforeRevealHandlers.isEmpty());
        currentHref = WindowGlobal.window().location().href;
        initialUrl = currentHref;
        // setUrl(currentHref);
        WindowGlobal.addEventListener("popstate", e -> {
            String newHref = WindowGlobal.window().location().href;
            if (!newHref.equals(this.currentHref)) {
                this.currentHref = newHref;
                this.setUrl(newHref);
            }
        });
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        containerPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    @Override
    public S setRevealHandler(RouteViewRevealHandler revealHandler) {
        setRevealHandlers(new ArrayList<RouteViewRevealHandler>(Arrays.asList(revealHandler)));
        return self();
    }

    @Override
    public S setBeforeRevealHandler(RouteViewBeforeRevealHandler beforeRevealHandler) {
        setBeforeRevealHandlers(new ArrayList<RouteViewBeforeRevealHandler>(Arrays.asList(beforeRevealHandler)));
        return self();
    }

    @Override
    public WebView getCurrentView() {
        return currentView;
    }

    @Override
    public S setCurrentView(WebView currentView) {
        this.currentView = currentView;
        return self();
    }
}
