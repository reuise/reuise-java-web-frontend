package dev.reuise.web.frontend.text;
import dev.reuise.core.ComponentAnimation;
import dev.reuise.web.core.text.WebParagraph;
import dev.reuise.web.frontend.WebFrontendComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
public interface WebFrontendParagraph extends WebFrontendParentComponent , WebParagraph , WebFrontendParagraphPart , WebFrontendComponent {
    WebFrontendParagraph getComponent();

    WebFrontendParagraph setAnimation(ComponentAnimation animation);

    WebFrontendParagraph startAnimation();

    WebFrontendParagraph cancelAnimation();
}
