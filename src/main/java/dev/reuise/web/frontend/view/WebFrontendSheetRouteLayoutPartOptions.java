package dev.reuise.web.frontend.view;
import akasha.Element;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentCreator;
import dev.reuise.web.core.view.RouteOptions;
import dev.reuise.web.core.view.RouteViewBeforeRevealHandler;
import dev.reuise.web.core.view.RouteViewRevealHandler;
import dev.reuise.web.core.view.RouteViewRevealer;
import dev.reuise.web.core.view.WebSheetRouteLayoutPartOptions;
import dev.reuise.web.core.view.WebView;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayoutPartOptions;
import java.util.List;
// Url here??
// Routes here??
// RouteViewRevealer here??
// RevealHandlers here??
// BeforeRevealHandlers here??
// CurrentView here??
public interface WebFrontendSheetRouteLayoutPartOptions extends WebSheetRouteLayoutPartOptions {
    WebFrontendSheetLayoutPartOptions getSheetLayoutPart();

    String getUrl();

    WebFrontendSheetRouteLayoutPartOptions setUrl(String url);

    List<RouteOptions> getRoutes();

    WebFrontendSheetRouteLayoutPartOptions setRoutes(List<RouteOptions> routes);

    WebFrontendSheetRouteLayoutPartOptions addRoute(RouteOptions route);

    WebFrontendSheetRouteLayoutPartOptions removeRoute(RouteOptions route);

    WebFrontendSheetRouteLayoutPartOptions clearRoutes();

    boolean hasRoute(RouteOptions route);

    RouteViewRevealer getRouteViewRevealer();

    WebFrontendSheetRouteLayoutPartOptions setRouteViewRevealer(RouteViewRevealer routeViewRevealer);

    List<RouteViewRevealHandler> getRevealHandlers();

    WebFrontendSheetRouteLayoutPartOptions setRevealHandlers(List<RouteViewRevealHandler> revealHandlers);

    WebFrontendSheetRouteLayoutPartOptions addRevealHandler(RouteViewRevealHandler revealHandler);

    WebFrontendSheetRouteLayoutPartOptions setRevealHandler(RouteViewRevealHandler revealHandler);

    WebFrontendSheetRouteLayoutPartOptions removeRevealHandler(RouteViewRevealHandler revealHandler);

    WebFrontendSheetRouteLayoutPartOptions clearRevealHandlers();

    List<RouteViewBeforeRevealHandler> getBeforeRevealHandlers();

    WebFrontendSheetRouteLayoutPartOptions setBeforeRevealHandlers(List<RouteViewBeforeRevealHandler> beforeRevealHandlers);

    WebFrontendSheetRouteLayoutPartOptions addBeforeRevealHandler(RouteViewBeforeRevealHandler beforeRevealHandler);

    WebFrontendSheetRouteLayoutPartOptions setBeforeRevealHandler(RouteViewBeforeRevealHandler beforeRevealHandler);

    WebFrontendSheetRouteLayoutPartOptions removeBeforeRevealHandler(RouteViewBeforeRevealHandler beforeRevealHandler);

    WebFrontendSheetRouteLayoutPartOptions clearBeforeRevealHandlers();

    WebView getCurrentView();

    WebFrontendSheetRouteLayoutPartOptions setCurrentView(WebView currentView);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    WebFrontendSheetRouteLayoutPartOptions setRouteLayoutCreator(ComponentCreator<? extends WebFrontendRouteLayout, ? extends WebFrontendRouteLayoutOptions> routeLayoutCreator);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendSheetRouteLayout getComponent();
}
