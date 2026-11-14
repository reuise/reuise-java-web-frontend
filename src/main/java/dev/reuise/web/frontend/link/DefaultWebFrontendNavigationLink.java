package dev.reuise.web.frontend.link;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLAnchorElement;
import akasha.HTMLElement;
import akasha.URL;
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
import dev.reuise.core.link.CoreLinkOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.link.DefaultWebNavigationLinkPart;
import dev.reuise.web.core.view.AntPathMatcher;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
// Option: UseHistoryApi - WEB
// Option: Text - CORE
// Option: Url - CORE
// Option: Target - CORE
// Option: ExternalIndicator - CORE
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
// base comp: link
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
public abstract class DefaultWebFrontendNavigationLink<S extends DefaultWebFrontendNavigationLink<S, O>, O extends WebFrontendNavigationLinkOptions> extends DefaultWebNavigationLinkPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendNavigationLink {
    private HTMLAnchorElement anchorEl;

    private String currentHref;

    private AntPathMatcher matcher = new AntPathMatcher();

    private void updateActive(String urlPath) {
        String href = getUrl();
        if ((href == null) || href.isEmpty()) {
            setActive(false);
            return;
        }
        URL linkUrl = new URL(href, WindowGlobal.document().location().href);
        setActive(checkPathMatch(urlPath, linkUrl.pathname));
    }

    protected final WebFrontendLinkPart linkPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendNavigationLink(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        linkPart = options.getComponentFactory().createLink(((CoreLinkOptions) (options.getLinkPart())));
        parentComponentPart = linkPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, linkPart);
    }

    @Override
    public S setUrl(String url, Boolean useHistoryApi) {
        this.linkPart.setUrl(url, useHistoryApi);
        return self();
    }

    public WebFrontendLinkPart getLinkPart() {
        return linkPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return linkPart.getRootComponent();
    }

    // Implementation
    @Override
    public void setRootComponent(RootComponent rootComponent) {
        if (rootComponent == null)
            return;

        this.parentComponentPart.setRootComponent(rootComponent);
        this.baseComponentPart.setRootComponent(rootComponent);
        // Todo: on path change
    }

    @Override
    public Theme getTheme() {
        return linkPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.linkPart.setTheme(theme);
        return self();
    }

    @Override
    public WebFrontendIcon getStartIcon() {
        return linkPart.getStartIcon();
    }

    @Override
    public WebFrontendIcon getEndIcon() {
        return linkPart.getEndIcon();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.linkPart.rehydrate(child);
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
        return linkPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return linkPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return linkPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return linkPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        linkPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        linkPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        linkPart.dispatchEvent(type);
    }

    public void click() {
        linkPart.click();
    }

    public boolean isRehydrated() {
        if (linkPart == null)
            return false;

        return linkPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return linkPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        linkPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return linkPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        linkPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        linkPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        linkPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        linkPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return linkPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return linkPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        linkPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return linkPart.getData(data);
    }

    public boolean hasData(String data) {
        return linkPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        linkPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return linkPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return linkPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return linkPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return linkPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return linkPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return linkPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return linkPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        linkPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return linkPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return linkPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return linkPart.hasWrapper();
    }

    public boolean isInitialized() {
        return linkPart.isInitialized();
    }

    public void log(Object obj) {
        linkPart.log(obj);
    }

    public void removeFromParent() {
        linkPart.removeFromParent();
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
    public WebFrontendNavigationLink getComponent() {
        return ((WebFrontendNavigationLink) (baseComponentPart.getComponent()));
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
        anchorEl = ((HTMLAnchorElement) (getHtmlElement()));
        currentHref = WindowGlobal.document().location().href;
        WindowGlobal.addEventListener("popstate", e -> {
            String newHref = WindowGlobal.document().location().href;
            if (!newHref.equals(currentHref)) {
                currentHref = newHref;
                String urlPath = WindowGlobal.document().location().pathname;
                updateActive(urlPath);
            }
        });
        String urlPath = WindowGlobal.document().location().pathname;
        updateActive(urlPath);
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        linkPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}
