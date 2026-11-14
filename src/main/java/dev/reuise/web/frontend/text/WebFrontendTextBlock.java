package dev.reuise.web.frontend.text;
import dev.reuise.web.core.text.WebTextBlock;
import dev.reuise.web.frontend.WebFrontendComponent;
public interface WebFrontendTextBlock extends WebFrontendText , WebTextBlock , WebFrontendComponent , WebFrontendTextBlockPart {
    WebFrontendTextBlock getComponent();
}
