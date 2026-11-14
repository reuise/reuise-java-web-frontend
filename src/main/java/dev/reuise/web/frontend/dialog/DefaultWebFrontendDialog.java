package dev.reuise.web.frontend.dialog;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.KeyboardEventListener;
import akasha.WindowGlobal;
import dev.reuise.core.ComponentPart;
import dev.reuise.core.ComponentType;
import dev.reuise.core.CoreComponent;
import dev.reuise.core.CoreComponentOptions;
import dev.reuise.core.Interaction;
import dev.reuise.core.Rect;
import dev.reuise.core.RootComponent;
import dev.reuise.core.ScreenSizeValues;
import dev.reuise.core.State;
import dev.reuise.core.button.CoreButton;
import dev.reuise.core.dialog.DialogSize;
import dev.reuise.core.event.Event;
import dev.reuise.core.event.EventType;
import dev.reuise.core.option.OptionApplicator;
import dev.reuise.core.parentcomponent.CoreParentComponentOptions;
import dev.reuise.core.theme.Theme;
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.dialog.DefaultWebDialogPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.event.BooleanEventHandler;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendHeading;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
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
public abstract class DefaultWebFrontendDialog<S extends DefaultWebFrontendDialog<S, O>, O extends WebFrontendDialogOptions> extends DefaultWebDialogPart<S, O> implements WebFrontendComponentType<S, O> , WebFrontendDialog {
    private KeyboardEventListener escapeKeyListener;

    @Override
    public void open() {
        if (!getElement().isConnected())
            WindowGlobal.document().body.append(getHtmlElement());

        super.open();
    }

    @Override
    public void shake() {
        super.shake();
        HTMLElement containerEl = getContainer().getHtmlElement();
        containerEl.addEventListener("animationend", evt -> {
            containerEl.classList().remove(getBaseStyleClass() + "--shaking");
        });
    }

    @Override
    public void close() {
        if (escapeKeyListener != null) {
            WindowGlobal.document().removeKeydownListener(escapeKeyListener);
            escapeKeyListener = null;
        }
        super.close();
    }

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected BooleanEventHandler acceptHandler;

    protected BooleanEventHandler cancelHandler;

    protected List<CoreButton> actions;

    protected DefaultWebFrontendDialog(O options) {
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
        if (container != null)
            container.setRootComponent(rootComponent);

        if (header != null)
            header.setRootComponent(rootComponent);

        if (titleHeading != null)
            titleHeading.setRootComponent(rootComponent);

        if (body != null)
            body.setRootComponent(rootComponent);

        if (footer != null)
            footer.setRootComponent(rootComponent);

        if (scrim != null)
            scrim.setRootComponent(rootComponent);

        if (acceptButton != null)
            acceptButton.setRootComponent(rootComponent);

        if (cancelButton != null)
            cancelButton.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return parentComponentPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (container != null)
            container.setTheme(theme);

        if (header != null)
            header.setTheme(theme);

        if (titleHeading != null)
            titleHeading.setTheme(theme);

        if (body != null)
            body.setTheme(theme);

        if (footer != null)
            footer.setTheme(theme);

        if (scrim != null)
            scrim.setTheme(theme);

        if (acceptButton != null)
            acceptButton.setTheme(theme);

        if (cancelButton != null)
            cancelButton.setTheme(theme);

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
    public WebFrontendDialog getComponent() {
        return ((WebFrontendDialog) (baseComponentPart.getComponent()));
    }

    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated())
            options.rehydrate(getElement());

        if (!super.onPreInitialize(options))
            return false;

        return true;
    }

    @Override
    public S rehydrate(CoreComponent child) {
        ((WebFrontendFlexContainerPart) (getBody())).rehydrate(child);
        return self();
    }

    // Implementation
    // Implementation
    // Implementation
    public void onInitialize(O options) {
        super.onInitialize(options);
        ((WebFrontendContainer) (this.scrim)).on(Event.CLICK, e -> {
            if (!this.isModal())
                this.close();
            else
                this.shake();

        });
        this.escapeKeyListener = e -> {
            if ((e != null) && ("Escape".equals(e.key()) || (e.keyCode() == 27))) {
                if (!this.isModal())
                    this.close();
                else
                    this.shake();

            }
        };
        WindowGlobal.document().addKeydownListener(escapeKeyListener);
        if (this.acceptButton != null) {
            WebFrontendButton webAcceptButton = ((WebFrontendButton) (this.acceptButton));
            Element acceptButtonEl = webAcceptButton.getElement();
            if (acceptButtonEl != null) {
                webAcceptButton.on(Event.CLICK, e -> {
                    if (this.acceptHandler == null)
                        this.close();
                    else if (this.acceptHandler.handleEvent(e))
                        this.close();

                });
            }
        }
        if (this.cancelButton != null) {
            WebFrontendButton webCancelButton = ((WebFrontendButton) (this.cancelButton));
            Element cancelButtonEl = webCancelButton.getElement();
            if (cancelButtonEl != null) {
                webCancelButton.on(Event.CLICK, e -> {
                    if (this.cancelHandler == null)
                        this.close();
                    else if (this.cancelHandler.handleEvent(e))
                        this.close();

                });
            }
        }
    }

    public void onCreate(O options) {
        super.onCreate(options);
    }

    public void applyOptions(O options, OptionApplicator applicator, Collection<State> states) {
        super.applyOptions(options, applicator, states);
        WebFrontendDialogPart component = ((WebFrontendDialogPart) (options.getComponent()));
        if (component == null)
            System.out.println("component is null");

        // Apply options for default state
        applicator.add(options.getAcceptHandlerOption(), component::setAcceptHandler);
        applicator.add(options.getCancelHandlerOption(), component::setCancelHandler);
    }

    public void onInitializeComponentType(RootComponent rootComponent) {
        if (isRehydrated() || ((WebRootComponent) (rootComponent)).isComponentTypeRegistered(getComponent().getClass()))
            return;

        super.onInitializeComponentType(rootComponent);
        parentComponentPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendContainer getContainer() {
        return ((WebFrontendContainer) (super.getContainer()));
    }

    @Override
    public WebFrontendContainer getHeader() {
        return ((WebFrontendContainer) (super.getHeader()));
    }

    @Override
    public WebFrontendHeading getTitleHeading() {
        return ((WebFrontendHeading) (super.getTitleHeading()));
    }

    @Override
    public WebFrontendFlexContainer getBody() {
        return ((WebFrontendFlexContainer) (super.getBody()));
    }

    @Override
    public WebFrontendFlexContainer getFooter() {
        return ((WebFrontendFlexContainer) (super.getFooter()));
    }

    @Override
    public WebFrontendContainer getScrim() {
        return ((WebFrontendContainer) (super.getScrim()));
    }

    @Override
    public WebFrontendButton getAcceptButton() {
        return ((WebFrontendButton) (super.getAcceptButton()));
    }

    @Override
    public WebFrontendButton getCancelButton() {
        return ((WebFrontendButton) (super.getCancelButton()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }

    @Override
    public BooleanEventHandler getAcceptHandler() {
        return acceptHandler;
    }

    @Override
    public S setAcceptHandler(BooleanEventHandler acceptHandler) {
        this.acceptHandler = acceptHandler;
        return self();
    }

    @Override
    public BooleanEventHandler getCancelHandler() {
        return cancelHandler;
    }

    @Override
    public S setCancelHandler(BooleanEventHandler cancelHandler) {
        this.cancelHandler = cancelHandler;
        return self();
    }

    @Override
    public S setSizeAllStates(DialogSize size) {
        setSize(ScreenSizeValues.of(size, size));
        setSize(size);
        return self();
    }

    @Override
    public List<CoreButton> getActions() {
        return actions;
    }

    // Implementation
    @Override
    public S setActions(List<CoreButton> actions) {
        return self();
    }

    // Implementation
    @Override
    public S addAction(CoreButton action) {
        return self();
    }

    // Implementation
    @Override
    public S setAction(CoreButton action) {
        return self();
    }

    // Implementation
    @Override
    public S removeAction(CoreButton action) {
        return self();
    }

    @Override
    public S clearActions() {
        this.actions.clear();
        return self();
    }
}
