package dev.reuise.web.frontend.chat;
import akasha.Element;
import akasha.EventListener;
import akasha.HTMLElement;
import akasha.HTMLTextAreaElement;
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
import dev.reuise.web.core.WebRootComponent;
import dev.reuise.web.core.chat.DefaultWebChatBoxPart;
import dev.reuise.web.frontend.ElementDataParser;
import dev.reuise.web.frontend.ElementProvider;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.WebFrontendComponentType;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentPart;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.floating.WebFrontendFloatingPanel;
import dev.reuise.web.frontend.input.WebFrontendBasicInputField;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerPart;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentPart;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
import dev.reuise.webstyles.Style;
import dev.reuise.webstyles.StyleBuilder;
import dev.reuise.webstyles.StyleSheetFactory;
import java.util.Collection;
import java.util.Set;
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
public abstract class DefaultWebFrontendChatBox<S extends DefaultWebFrontendChatBox<S, O>, O extends WebFrontendChatBoxOptions> extends DefaultWebChatBoxPart<S, O> implements WebFrontendChatBox , WebFrontendComponentType<S, O> {
    private HTMLElement hydrationFocus;

    private int selectionStart;

    private int selectionEnd;

    private String selectionDirection;

    @Override
    public S setLoading(Boolean loading) {
        Element active = WindowGlobal.document().activeElement();
        boolean sendFocused = (getSendButton() != null) && (getSendButton().getElement() == active);
        boolean stopFocused = (getStopButton() != null) && (getStopButton().getElement() == active);
        boolean retryFocused = (getRetryButton() != null) && (getRetryButton().getElement() == active);
        super.setLoading(loading);
        if ((isLoading() && (sendFocused || retryFocused)) && (getStopButton() != null))
            getStopButton().getHtmlElement().focus();
        else if (((!isLoading()) && stopFocused) && (getSendButton() != null))
            getSendButton().getHtmlElement().focus();

        return self();
    }

    @Override
    public S setErrorMessage(String errorMessage) {
        boolean retryFocused = (getRetryButton() != null) && (WindowGlobal.document().activeElement() == getRetryButton().getElement());
        super.setErrorMessage(errorMessage);
        if ((retryFocused && ((errorMessage == null) || errorMessage.isEmpty())) && (getComposer() != null))
            getComposer().getHtmlElement().focus();

        return self();
    }

    @Override
    public S setHandoffStatus(String handoffStatus) {
        boolean requestFocused = (getRequestHumanButton() != null) && (WindowGlobal.document().activeElement() == getRequestHumanButton().getElement());
        super.setHandoffStatus(handoffStatus);
        if ((requestFocused && (!"available".equals(getHandoffStatus()))) && (getComposer() != null))
            getComposer().getHtmlElement().focus();

        return self();
    }

    protected final WebFrontendContainerPart containerPart;

    protected final WebFrontendParentComponentPart parentComponentPart;

    protected final WebFrontendBaseComponentPart baseComponentPart;

    protected DefaultWebFrontendChatBox(O options) {
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

    @Override
    public void setRootComponent(RootComponent rootComponent) {
        super.setRootComponent(rootComponent);
        this.containerPart.setRootComponent(rootComponent);
        if (floatingPanel != null)
            floatingPanel.setRootComponent(rootComponent);

        if (chatContent != null)
            chatContent.setRootComponent(rootComponent);

        if (messages != null)
            messages.setRootComponent(rootComponent);

        if (loadingIndicator != null)
            loadingIndicator.setRootComponent(rootComponent);

        if (errorDisplay != null)
            errorDisplay.setRootComponent(rootComponent);

        if (retryButton != null)
            retryButton.setRootComponent(rootComponent);

        if (handoffDisplay != null)
            handoffDisplay.setRootComponent(rootComponent);

        if (requestHumanButton != null)
            requestHumanButton.setRootComponent(rootComponent);

        if (composerArea != null)
            composerArea.setRootComponent(rootComponent);

        if (composer != null)
            composer.setRootComponent(rootComponent);

        if (sendButton != null)
            sendButton.setRootComponent(rootComponent);

        if (stopButton != null)
            stopButton.setRootComponent(rootComponent);

    }

    @Override
    public Theme getTheme() {
        return containerPart.getTheme();
    }

    @Override
    public S setTheme(Theme theme) {
        super.setTheme(theme);
        if (floatingPanel != null)
            floatingPanel.setTheme(theme);

        if (chatContent != null)
            chatContent.setTheme(theme);

        if (messages != null)
            messages.setTheme(theme);

        if (loadingIndicator != null)
            loadingIndicator.setTheme(theme);

        if (errorDisplay != null)
            errorDisplay.setTheme(theme);

        if (retryButton != null)
            retryButton.setTheme(theme);

        if (handoffDisplay != null)
            handoffDisplay.setTheme(theme);

        if (requestHumanButton != null)
            requestHumanButton.setTheme(theme);

        if (composerArea != null)
            composerArea.setTheme(theme);

        if (composer != null)
            composer.setTheme(theme);

        if (sendButton != null)
            sendButton.setTheme(theme);

        if (stopButton != null)
            stopButton.setTheme(theme);

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
    public WebFrontendChatBox getComponent() {
        return ((WebFrontendChatBox) (baseComponentPart.getComponent()));
    }

    // Implementation
    // Implementation
    // Implementation
    public boolean onPreInitialize(O options) {
        if ((options != null) && options.isRehydrated()) {
            Element active = WindowGlobal.document().activeElement();
            if (((active instanceof HTMLElement) && getElement().contains(active)) && (active.closest(".reuise-chatbox_chatcontent") != null)) {
                hydrationFocus = ((HTMLElement) (active));
                if (active instanceof HTMLTextAreaElement) {
                    HTMLTextAreaElement textarea = ((HTMLTextAreaElement) (active));
                    selectionStart = textarea.selectionStart;
                    selectionEnd = textarea.selectionEnd;
                    selectionDirection = textarea.selectionDirection;
                }
            }
            options.rehydrate(getElement());
        }
        return super.onPreInitialize(options);
    }

    // Implementation
    // Implementation
    // Implementation
    public void onInitialize(O options) {
        super.onInitialize(options);
        if ((((hydrationFocus != null) && hydrationFocus.isConnected()) && (WindowGlobal.document().activeElement() == WindowGlobal.document().body)) && (hydrationFocus.closest("[hidden],[inert],[disabled]") == null)) {
            hydrationFocus.focus();
            if (hydrationFocus instanceof HTMLTextAreaElement)
                ((HTMLTextAreaElement) (hydrationFocus)).setSelectionRange(selectionStart, selectionEnd, selectionDirection);

        }
        hydrationFocus = null;
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
        containerPart.onInitializeComponentType(rootComponent);
        onInitializeCommonStyle(((WebRootComponent) (rootComponent)).getCommonStyles());
    }

    @Override
    public WebFrontendFloatingPanel getFloatingPanel() {
        return ((WebFrontendFloatingPanel) (super.getFloatingPanel()));
    }

    @Override
    public WebFrontendContainer getChatContent() {
        return ((WebFrontendContainer) (super.getChatContent()));
    }

    @Override
    public WebFrontendContainer getMessages() {
        return ((WebFrontendContainer) (super.getMessages()));
    }

    @Override
    public WebFrontendParagraph getLoadingIndicator() {
        return ((WebFrontendParagraph) (super.getLoadingIndicator()));
    }

    @Override
    public WebFrontendParagraph getErrorDisplay() {
        return ((WebFrontendParagraph) (super.getErrorDisplay()));
    }

    @Override
    public WebFrontendButton getRetryButton() {
        return ((WebFrontendButton) (super.getRetryButton()));
    }

    @Override
    public WebFrontendParagraph getHandoffDisplay() {
        return ((WebFrontendParagraph) (super.getHandoffDisplay()));
    }

    @Override
    public WebFrontendButton getRequestHumanButton() {
        return ((WebFrontendButton) (super.getRequestHumanButton()));
    }

    @Override
    public WebFrontendContainer getComposerArea() {
        return ((WebFrontendContainer) (super.getComposerArea()));
    }

    @Override
    public WebFrontendBasicInputField getComposer() {
        return ((WebFrontendBasicInputField) (super.getComposer()));
    }

    @Override
    public WebFrontendButton getSendButton() {
        return ((WebFrontendButton) (super.getSendButton()));
    }

    @Override
    public WebFrontendButton getStopButton() {
        return ((WebFrontendButton) (super.getStopButton()));
    }

    public void onInitializeCommonStyle(StyleBuilder commonStyles) {
        super.onInitializeCommonStyle(commonStyles);
    }
}
