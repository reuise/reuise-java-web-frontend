package dev.reuise.web.frontend.menu;
import akasha.CSSStyleDeclaration;
import akasha.DOMRect;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.Node;
import akasha.WindowGlobal;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Position;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.State;
import dev.reuise.core.event.EventType;
import dev.reuise.core.menu.CoreMenuItem;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.parentcomponent.CoreParentComponentOptions;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.menu.DefaultWebMenuPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.list.WebFrontendListView;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
public abstract class DefaultWebFrontendMenu<S extends DefaultWebFrontendMenu<S, O>, O extends WebFrontendMenuOptions> extends DefaultWebMenuPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendMenu {
    private EventListener docClickListener;

    // During rehydration, the server-rendered <li> items already exist in the DOM and must be
    // reused as-is. The default setItems() wipes the list (removeAll()) before re-adding each
    // item; since the rehydrating items' own element lookups match against those same DOM nodes
    // by selector, wiping them first leaves nothing to match and the items silently vanish.
    // Skip the destructive rebuild while rehydrating and trust the existing markup instead.
    @Override
    public S setItems(List<CoreMenuItem> items) {
        if (isRehydrated())
            return self();

        return super.setItems(items);
    }

    @Override
    public void open() {
        if (this.anchor == null)
            return;

        WebFrontendComponent webAnchor = ((WebFrontendComponent) (this.anchor));
        HTMLElement webAnchorEl = webAnchor.getHtmlElement();
        open(webAnchorEl);
    }

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected CoreComponent anchor;

    protected Position anchorPosition;

    protected Position menuPosition;

    protected DefaultWebFrontendMenu(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        parentComponentPart = options.getComponentFactory().createParentComponent(((CoreParentComponentOptions) (options.getParentComponentPart())));
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, parentComponentPart);
    }

    public WebFrontendParentComponentPart getParentComponentPart() {
        return parentComponentPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return parentComponentPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.parentComponentPart.setRootComponent(rootComponent);
        if (list != null)
            list.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return parentComponentPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (list != null)
            list.setTheme(theme);

        this.parentComponentPart.setTheme(theme);
        return self();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.parentComponentPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(getRootComponent());
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
    public WebFrontendMenu getComponent() {
        return ((WebFrontendMenu) (baseComponentPart.getComponent()));
    }

    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated())
            options.rehydrate(getElement());

        if (!super.onPreInitialize(options))
            return false;

        return true;
    }

    // Implementation
    // Implementation
    // Implementation
    public void onInitialize(O options) {
        super.onInitialize(options);
        WindowGlobal.document().body.appendChild(getElement());
        HTMLElement menuEl = getHtmlElement();
        if (menuEl != null) {
            menuEl.addEventListener("click", e -> {
                Element target = ((Element) (e.target()));
                if ((target != null) && (target.closest(".reuise-menuitem") != null))
                    close();

            });
        }
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
    public WebFrontendListView getList() {
        return ((WebFrontendListView) (super.getList()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    @Override
    public CoreComponent getAnchor() {
        return anchor;
    }

    @Override
    public S setAnchor(CoreComponent anchor) {
        this.anchor = anchor;
        return self();
    }

    @Override
    public S setItem(CoreMenuItem item) {
        setItems(new ArrayList<CoreMenuItem>(Arrays.asList(item)));
        return self();
    }

    @Override
    public Position getAnchorPosition() {
        return anchorPosition;
    }

    @Override
    public S setAnchorPosition(Position anchorPosition) {
        this.anchorPosition = anchorPosition;
        return self();
    }

    @Override
    public Position getMenuPosition() {
        return menuPosition;
    }

    @Override
    public S setMenuPosition(Position menuPosition) {
        this.menuPosition = menuPosition;
        return self();
    }

    // Implementation
    public void open(HTMLElement element) {
        if (element == null)
            return;

        HTMLElement menuEl = getHtmlElement();
        if (menuEl == null)
            return;

        CSSStyleDeclaration menuElStyle = menuEl.style();
        // Clear any height limit from a previous open so the natural height is measured
        menuElStyle.removeProperty("max-height");
        menuElStyle.removeProperty("overflow-y");
        DOMRect anchorRect = element.getBoundingClientRect();
        DOMRect menuRect = menuEl.getBoundingClientRect();
        double y = anchorRect.top();
        double x = anchorRect.left();
        if (anchorPosition.isCenterX())
            x += anchorRect.width() / 2;
        else if (anchorPosition.isRight())
            x = anchorRect.right();

        if (anchorPosition.isCenterY())
            y += anchorRect.height() / 2;
        else if (anchorPosition.isBottom())
            y = anchorRect.bottom();

        if (menuPosition.isCenterX())
            x -= menuRect.width() / 2;
        else if (menuPosition.isRight())
            x -= menuRect.width();

        if (menuPosition.isCenterY())
            y -= menuRect.height() / 2;
        else if (menuPosition.isTop())
            y -= menuRect.height();

        // A menu attached to the bottom edge of its anchor opens downwards when it fits, otherwise
        // above the anchor (and the reverse for a menu attached to the top edge). If neither side
        // fits, the larger side is used and the menu scrolls.
        boolean opensDown = (anchorPosition.isBottom() && (!menuPosition.isTop())) && (!menuPosition.isCenterY());
        boolean opensUp = anchorPosition.isTop() && menuPosition.isTop();
        if (opensDown || opensUp) {
            double margin = 8;
            double menuHeight = menuRect.height();
            double spaceBelow = (WindowGlobal.innerHeight() - anchorRect.bottom()) - margin;
            double spaceAbove = anchorRect.top() - margin;
            boolean placeBelow;
            if (opensDown)
                placeBelow = (menuHeight <= spaceBelow) || (spaceBelow >= spaceAbove);
            else
                placeBelow = (menuHeight > spaceAbove) && (spaceBelow > spaceAbove);

            double available = (placeBelow) ? spaceBelow : spaceAbove;
            double height = menuHeight;
            if (menuHeight > available) {
                height = Math.max(available, 0);
                menuElStyle.setProperty("max-height", height + "px");
                menuElStyle.setProperty("overflow-y", "auto");
            }
            y = (placeBelow) ? anchorRect.bottom() : anchorRect.top() - height;
        }
        menuElStyle.setProperty("top", y + "px");
        menuElStyle.setProperty("left", x + "px");
        super.open();
        docClickListener = e -> {
            if (!menuEl.contains(((Node) (e.target())))) {
                super.close();
                WindowGlobal.document().removeEventListener("mousedown", docClickListener);
            }
        };
        WindowGlobal.document().addEventListener("mousedown", docClickListener);
    }
}
