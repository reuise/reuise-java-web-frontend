package dev.reuise.web.frontend.menu;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.State;
import dev.reuise.core.event.EventType;
import dev.reuise.core.list.CoreListItemOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.menu.DefaultWebMenuItemPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.list.WebFrontendBasicListItemPart;
import dev.reuise.web.frontend.list.WebFrontendListItemPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
// Option: Loading - CORE
// Option: SkeletonOptions - CORE
// Option: Label - CORE
// Option: SecondaryLabel - CORE
// Option: HasCheckbox - CORE
// Option: ToggleCheckboxOnClick - CORE
// Option: Url - CORE
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
// base comp: listItem
// base comp: basicListItem
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
public abstract class DefaultWebFrontendMenuItem<S extends DefaultWebFrontendMenuItem<S, O>, O extends WebFrontendMenuItemOptions> extends DefaultWebMenuItemPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendMenuItem {
    protected final WebFrontendListItemPart listItemPart;

    protected final WebFrontendBasicListItemPart basicListItemPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendMenuItem(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        listItemPart = options.getComponentFactory().createListItem(((CoreListItemOptions) (options.getListItemPart())));
        basicListItemPart = listItemPart.getBasicListItemPart();
        parentComponentPart = basicListItemPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, listItemPart);
    }

    @Override
    public S setHighlightText(String text) {
        return ((S) (listItemPart.setHighlightText(text)));
    }

    @Override
    public S setFilterText(String text) {
        return ((S) (listItemPart.setFilterText(text)));
    }

    @Override
    public boolean containsText(String text) {
        return ((boolean) (listItemPart.containsText(text)));
    }

    public WebFrontendListItemPart getListItemPart() {
        return listItemPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return listItemPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.listItemPart.setRootComponent(rootComponent);
    }

    @Override
    public Theme getTheme() {
        return listItemPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.listItemPart.setTheme(theme);
        return self();
    }

    @Override
    public WebFrontendCheckbox getCheckbox() {
        return listItemPart.getCheckbox();
    }

    @Override
    public WebFrontendIcon getStartIcon() {
        return listItemPart.getStartIcon();
    }

    @Override
    public WebFrontendContainer getTextContainer() {
        return listItemPart.getTextContainer();
    }

    @Override
    public WebFrontendInlineText getLabelContainer() {
        return listItemPart.getLabelContainer();
    }

    @Override
    public WebFrontendInlineText getSecondaryLabelContainer() {
        return listItemPart.getSecondaryLabelContainer();
    }

    @Override
    public WebFrontendIcon getEndIcon() {
        return listItemPart.getEndIcon();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.listItemPart.rehydrate(child);
        child.setParent(self());
        child.setRootComponent(getRootComponent());
        return self();
    }

    @Override
    public S setUrl(String url, Boolean useHistoryApi) {
        this.basicListItemPart.setUrl(url, useHistoryApi);
        return self();
    }

    public WebFrontendBasicListItemPart getBasicListItemPart() {
        return basicListItemPart;
    }

    @Override
    public WebFrontendLink getLink() {
        return basicListItemPart.getLink();
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
        return listItemPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return listItemPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return listItemPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return listItemPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        listItemPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        listItemPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        listItemPart.dispatchEvent(type);
    }

    public void click() {
        listItemPart.click();
    }

    public boolean isRehydrated() {
        if (listItemPart == null)
            return false;

        return listItemPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return listItemPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        listItemPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return listItemPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        listItemPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        listItemPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        listItemPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        listItemPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return listItemPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return listItemPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        listItemPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return listItemPart.getData(data);
    }

    public boolean hasData(String data) {
        return listItemPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        listItemPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return listItemPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return listItemPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return listItemPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return listItemPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return listItemPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return listItemPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return listItemPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        listItemPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return listItemPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return listItemPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return listItemPart.hasWrapper();
    }

    public boolean isInitialized() {
        return listItemPart.isInitialized();
    }

    public void log(Object obj) {
        listItemPart.log(obj);
    }

    public void removeFromParent() {
        listItemPart.removeFromParent();
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
    public WebFrontendMenuItem getComponent() {
        return ((WebFrontendMenuItem) (baseComponentPart.getComponent()));
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
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        listItemPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}
