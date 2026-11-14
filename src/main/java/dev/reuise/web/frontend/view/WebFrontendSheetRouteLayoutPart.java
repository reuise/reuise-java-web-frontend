package dev.reuise.web.frontend.view;
import dev.reuise.web.core.view.RouteOptions;
import dev.reuise.web.core.view.RouteViewBeforeRevealHandler;
import dev.reuise.web.core.view.RouteViewRevealHandler;
import dev.reuise.web.core.view.RouteViewRevealer;
import dev.reuise.web.core.view.WebSheetRouteLayoutPart;
import dev.reuise.web.core.view.WebView;
import dev.reuise.web.frontend.WebFrontendComponentPart;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayoutPart;
import java.util.List;
// Url here??
// Routes here??
// RouteViewRevealer here??
// RevealHandlers here??
// BeforeRevealHandlers here??
// CurrentView here??
public interface WebFrontendSheetRouteLayoutPart extends WebFrontendComponentPart , WebSheetRouteLayoutPart , WebFrontendSheetRouteLayoutFeatures , WebFrontendSheetLayoutPart {
    String getUrl();

    WebFrontendSheetRouteLayoutPart setUrl(String url);

    List<RouteOptions> getRoutes();

    WebFrontendSheetRouteLayoutPart setRoutes(List<RouteOptions> routes);

    WebFrontendSheetRouteLayoutPart addRoute(RouteOptions route);

    WebFrontendSheetRouteLayoutPart removeRoute(RouteOptions route);

    WebFrontendSheetRouteLayoutPart clearRoutes();

    boolean hasRoute(RouteOptions route);

    RouteViewRevealer getRouteViewRevealer();

    WebFrontendSheetRouteLayoutPart setRouteViewRevealer(RouteViewRevealer routeViewRevealer);

    List<RouteViewRevealHandler> getRevealHandlers();

    WebFrontendSheetRouteLayoutPart setRevealHandlers(List<RouteViewRevealHandler> revealHandlers);

    WebFrontendSheetRouteLayoutPart addRevealHandler(RouteViewRevealHandler revealHandler);

    WebFrontendSheetRouteLayoutPart setRevealHandler(RouteViewRevealHandler revealHandler);

    WebFrontendSheetRouteLayoutPart removeRevealHandler(RouteViewRevealHandler revealHandler);

    WebFrontendSheetRouteLayoutPart clearRevealHandlers();

    List<RouteViewBeforeRevealHandler> getBeforeRevealHandlers();

    WebFrontendSheetRouteLayoutPart setBeforeRevealHandlers(List<RouteViewBeforeRevealHandler> beforeRevealHandlers);

    WebFrontendSheetRouteLayoutPart addBeforeRevealHandler(RouteViewBeforeRevealHandler beforeRevealHandler);

    WebFrontendSheetRouteLayoutPart setBeforeRevealHandler(RouteViewBeforeRevealHandler beforeRevealHandler);

    WebFrontendSheetRouteLayoutPart removeBeforeRevealHandler(RouteViewBeforeRevealHandler beforeRevealHandler);

    WebFrontendSheetRouteLayoutPart clearBeforeRevealHandlers();

    WebView getCurrentView();

    WebFrontendSheetRouteLayoutPart setCurrentView(WebView currentView);

    WebFrontendRouteLayout getRouteLayout();

    WebFrontendSheetLayoutPart getSheetLayoutPart();
}
