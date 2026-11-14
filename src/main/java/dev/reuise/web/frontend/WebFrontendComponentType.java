package dev.reuise.web.frontend;
import dev.reuise.web.core.WebComponentType;
public interface WebFrontendComponentType<C extends WebFrontendComponent, O extends WebFrontendComponentOptions> extends WebFrontendComponentPart , WebComponentType<C, O> , WebFrontendComponent {}
