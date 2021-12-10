package dev.reuise.web.frontend;
import dev.reuise.web.frontend.button.Button;
import dev.reuise.web.frontend.document.Document;
import dev.reuise.web.frontend.label.Label;
import org.junit.Test;
public class ComponentTests {
    @Test
    public void createLabel() {
        Label label = new Label(Label.newOptions());
    }

    @Test
    public void createButton() {
        Button button = new Button(Button.newOptions().setId("example-button").setLabel("Example button"));
    }

    @Test
    public void createDocument() {
        Document document = new Document(Document.newOptions());
    }
}