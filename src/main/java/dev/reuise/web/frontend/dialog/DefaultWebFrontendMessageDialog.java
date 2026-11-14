package dev.reuise.web.frontend.dialog;
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
import dev.reuise.core.dialog.CoreDialogOptions;
import dev.reuise.core.event.EventType;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.dialog.DefaultWebMessageDialogPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.event.BooleanEventHandler;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendHeading;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
// Option: AcceptHandler - WEB_FRONTEND
// Option: CancelHandler - WEB_FRONTEND
// Option: Title - CORE
// Option: Open - CORE
// Option: Size - CORE
// Option: RemoveOnClose - CORE
// Option: Modal - CORE
// Option: Actions - CORE
// Option: HasAcceptButton - CORE
// Option: HasCancelButton - CORE
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
// base comp: dialog
// add composition for dialog: open
// add composition for dialog: close
// add composition for dialog: shake
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
public abstract class DefaultWebFrontendMessageDialog<S extends DefaultWebFrontendMessageDialog<S, O>, O extends WebFrontendMessageDialogOptions> extends DefaultWebMessageDialogPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendMessageDialog {
    protected final WebFrontendDialogPart dialogPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendMessageDialog(O options) {
        super(options);
        if (options.getComponent() == null)
            options.setComponent(self());

        dialogPart = options.getComponentFactory().createDialog(((CoreDialogOptions) (options.getDialogPart())));
        parentComponentPart = dialogPart.getParentComponentPart();
        baseComponentPart = parentComponentPart.getBaseComponentPart();
        addPart(ComponentPart.Type.BASE, dialogPart);
    }

    @Override
    public BooleanEventHandler getAcceptHandler() {
        return dialogPart.getAcceptHandler();
    }

    @Override
    public S setAcceptHandler(BooleanEventHandler acceptHandler) {
        this.dialogPart.setAcceptHandler(acceptHandler);
        return self();
    }

    @Override
    public BooleanEventHandler getCancelHandler() {
        return dialogPart.getCancelHandler();
    }

    @Override
    public S setCancelHandler(BooleanEventHandler cancelHandler) {
        this.dialogPart.setCancelHandler(cancelHandler);
        return self();
    }

    public void open() {
        dialogPart.open();
    }

    public void close() {
        dialogPart.close();
    }

    public void shake() {
        dialogPart.shake();
    }

    public WebFrontendDialogPart getDialogPart() {
        return dialogPart;
    }

    @Override
    public RootComponent getRootComponent() {
        return dialogPart.getRootComponent();
    }

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        this.dialogPart.setRootComponent(rootComponent);
    }

    @Override
    public Theme getTheme() {
        return dialogPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        this.dialogPart.setTheme(theme);
        return self();
    }

    @Override
    public WebFrontendContainer getContainer() {
        return dialogPart.getContainer();
    }

    @Override
    public WebFrontendContainer getHeader() {
        return dialogPart.getHeader();
    }

    @Override
    public WebFrontendHeading getTitleHeading() {
        return dialogPart.getTitleHeading();
    }

    @Override
    public WebFrontendFlexContainer getBody() {
        return dialogPart.getBody();
    }

    @Override
    public WebFrontendFlexContainer getFooter() {
        return dialogPart.getFooter();
    }

    @Override
    public WebFrontendContainer getScrim() {
        return dialogPart.getScrim();
    }

    @Override
    public WebFrontendButton getAcceptButton() {
        return dialogPart.getAcceptButton();
    }

    @Override
    public WebFrontendButton getCancelButton() {
        return dialogPart.getCancelButton();
    }

    @Override
    public S rehydrate(CoreComponent child) {
        this.dialogPart.rehydrate(child);
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
        return dialogPart.getElement();
    }

    public HTMLElement getHtmlElement() {
        return dialogPart.getHtmlElement();
    }

    public Rect getBoundingBox() {
        return dialogPart.getBoundingBox();
    }

    public HTMLElement createOrRehydrateElement(String tagName, String selector) {
        return dialogPart.createOrRehydrateElement(tagName, selector);
    }

    public S on(EventType type, EventListener listener) {
        dialogPart.on(type, listener);
        return self();
    }

    public S on(Set<EventType> types, EventListener listener) {
        dialogPart.on(types, listener);
        return self();
    }

    public void dispatchEvent(EventType type) {
        dialogPart.dispatchEvent(type);
    }

    public void click() {
        dialogPart.click();
    }

    public boolean isRehydrated() {
        if (dialogPart == null)
            return false;

        return dialogPart.isRehydrated();
    }

    public Style getComputedStyle() {
        return dialogPart.getComputedStyle();
    }

    public S addOrRemoveStyleClass(String styleClass, boolean add) {
        dialogPart.addOrRemoveStyleClass(styleClass, add);
        return self();
    }

    public boolean hasStyleClass(String styleClass) {
        return dialogPart.hasStyleClass(styleClass);
    }

    public S removeStyleClass(String styleClass) {
        dialogPart.removeStyleClass(styleClass);
        return self();
    }

    public S setAttribute(String attribute, String value) {
        dialogPart.setAttribute(attribute, value);
        return self();
    }

    public S setAttribute(String attribute) {
        dialogPart.setAttribute(attribute);
        return self();
    }

    public S removeAttribute(String attribute) {
        dialogPart.removeAttribute(attribute);
        return self();
    }

    public String getAttribute(String attribute) {
        return dialogPart.getAttribute(attribute);
    }

    public boolean hasAttribute(String attribute) {
        return dialogPart.hasAttribute(attribute);
    }

    public S setData(String data, String value) {
        dialogPart.setData(data, value);
        return self();
    }

    public String getData(String data) {
        return dialogPart.getData(data);
    }

    public boolean hasData(String data) {
        return dialogPart.hasData(data);
    }

    public S setAria(String attribute, String value) {
        dialogPart.setAria(attribute, value);
        return self();
    }

    public String getAria(String attribute) {
        return dialogPart.getAria(attribute);
    }

    public boolean hasAria(String attribute) {
        return dialogPart.hasAria(attribute);
    }

    public String getUniqueId() {
        return dialogPart.getUniqueId();
    }

    public String getUniqueStyleClass() {
        return dialogPart.getUniqueStyleClass();
    }

    public String getStyleSheetId() {
        return dialogPart.getStyleSheetId();
    }

    public String getStyleSheetId(State state) {
        return dialogPart.getStyleSheetId(state);
    }

    public Set<State> getStyleStates() {
        return dialogPart.getStyleStates();
    }

    public void setStyleSheetFactory(StyleSheetFactory styleSheetFactory) {
        dialogPart.setStyleSheetFactory(styleSheetFactory);
    }

    public Style getStyle(State state, Interaction interaction) {
        return dialogPart.getStyle(state, interaction);
    }

    public Style getStyle(Interaction interaction) {
        return dialogPart.getStyle(interaction);
    }

    public boolean hasWrapper() {
        return dialogPart.hasWrapper();
    }

    public boolean isInitialized() {
        return dialogPart.isInitialized();
    }

    public void log(Object obj) {
        dialogPart.log(obj);
    }

    public void removeFromParent() {
        dialogPart.removeFromParent();
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
    public WebFrontendMessageDialog getComponent() {
        return ((WebFrontendMessageDialog) (baseComponentPart.getComponent()));
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
        dialogPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}
