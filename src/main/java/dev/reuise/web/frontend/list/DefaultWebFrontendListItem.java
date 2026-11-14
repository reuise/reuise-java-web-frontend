package dev.reuise.web.frontend.list;
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
import dev.reuise.core.list.CoreBasicListItemOptions;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.list.DefaultWebListItemPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
import dev.reuise.web.frontend.event.Event;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
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
public abstract class DefaultWebFrontendListItem<S extends DefaultWebFrontendListItem<S, O>, O extends WebFrontendListItemOptions> extends DefaultWebListItemPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendListItem {
    private EventListener toggleCheckboxOnClickListener = null;

    @Override
    public S setToggleCheckboxOnClick(Boolean toggleCheckboxOnClick) {
        super.setToggleCheckboxOnClick(toggleCheckboxOnClick);
        enableClickListener(Boolean.TRUE.equals(toggleCheckboxOnClick));
        return self();
    }

    @Override
    public boolean isToggleCheckboxOnClick() {
        return (checkbox != null) && (toggleCheckboxOnClickListener != null);
    }

    private void enableClickListener(boolean enable) {
        if ((checkbox != null) && enable) {
            if (toggleCheckboxOnClickListener != null)
                return;

            toggleCheckboxOnClickListener = e -> {
                Element target = ((Element) (e.target()));
                if ((target != null) && (target.closest(".reuise-listitem_checkbox") == null)) {
                    this.checkbox.toggle();
                    ((WebFrontendCheckbox) (this.checkbox)).dispatchEvent(Event.CHANGE);
                    e.preventDefault();
                }
            };
            getHtmlElement().addEventListener("click", toggleCheckboxOnClickListener);
        } else {
            if (toggleCheckboxOnClickListener != null)
                getHtmlElement().removeEventListener("click", toggleCheckboxOnClickListener);

            toggleCheckboxOnClickListener = null;
        }
    }

    protected final WebFrontendBasicListItemPart basicListItemPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendListItem(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        basicListItemPart = options.getComponentFactory().createBasicListItem(((CoreBasicListItemOptions) (options.getBasicListItemPart())));
        parentComponentPart = basicListItemPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, basicListItemPart);
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
    public RootComponent getRootComponent() {
        return basicListItemPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.basicListItemPart.setRootComponent(rootComponent);
        if (checkbox != null)
            checkbox.setRootComponent(rootComponent);

        if (startIcon != null)
            startIcon.setRootComponent(rootComponent);

        if (textContainer != null)
            textContainer.setRootComponent(rootComponent);

        if (labelContainer != null)
            labelContainer.setRootComponent(rootComponent);

        if (secondaryLabelContainer != null)
            secondaryLabelContainer.setRootComponent(rootComponent);

        if (endIcon != null)
            endIcon.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return basicListItemPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (checkbox != null)
            checkbox.setTheme(theme);

        if (startIcon != null)
            startIcon.setTheme(theme);

        if (textContainer != null)
            textContainer.setTheme(theme);

        if (labelContainer != null)
            labelContainer.setTheme(theme);

        if (secondaryLabelContainer != null)
            secondaryLabelContainer.setTheme(theme);

        if (endIcon != null)
            endIcon.setTheme(theme);

        this.basicListItemPart.setTheme(theme);
        return self();
    }

    @Override
    public WebFrontendLink getLink() {
        return basicListItemPart.getLink();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.basicListItemPart.rehydrate(child);
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
        return basicListItemPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return basicListItemPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return basicListItemPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return basicListItemPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        basicListItemPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        basicListItemPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        basicListItemPart.dispatchEvent(type);
    }

    public void click() {
        basicListItemPart.click();
    }

    public boolean isRehydrated() {
        if (basicListItemPart == null)
            return false;

        return basicListItemPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return basicListItemPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        basicListItemPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return basicListItemPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        basicListItemPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        basicListItemPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        basicListItemPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        basicListItemPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return basicListItemPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return basicListItemPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        basicListItemPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return basicListItemPart.getData(data);
    }

    public boolean hasData(String data) {
        return basicListItemPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        basicListItemPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return basicListItemPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return basicListItemPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return basicListItemPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return basicListItemPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return basicListItemPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return basicListItemPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return basicListItemPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        basicListItemPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return basicListItemPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return basicListItemPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return basicListItemPart.hasWrapper();
    }

    public boolean isInitialized() {
        return basicListItemPart.isInitialized();
    }

    public void log(Object obj) {
        basicListItemPart.log(obj);
    }

    public void removeFromParent() {
        basicListItemPart.removeFromParent();
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
    public WebFrontendListItem getComponent() {
        return ((WebFrontendListItem) (baseComponentPart.getComponent()));
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
        enableClickListener(Boolean.TRUE.equals(options.isToggleCheckboxOnClick()));
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        basicListItemPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendCheckbox getCheckbox() {
        return ((WebFrontendCheckbox) (super.getCheckbox()));
    }

    @Override
    public WebFrontendIcon getStartIcon() {
        return ((WebFrontendIcon) (super.getStartIcon()));
    }

    @Override
    public WebFrontendContainer getTextContainer() {
        return ((WebFrontendContainer) (super.getTextContainer()));
    }

    @Override
    public WebFrontendInlineText getLabelContainer() {
        return ((WebFrontendInlineText) (super.getLabelContainer()));
    }

    @Override
    public WebFrontendInlineText getSecondaryLabelContainer() {
        return ((WebFrontendInlineText) (super.getSecondaryLabelContainer()));
    }

    @Override
    public WebFrontendIcon getEndIcon() {
        return ((WebFrontendIcon) (super.getEndIcon()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}
