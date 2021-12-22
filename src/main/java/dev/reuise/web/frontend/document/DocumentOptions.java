package dev.reuise.web.frontend.document;
import dev.reuise.web.core.document.WebDocumentOptions;
import dev.reuise.web.frontend.parentcomponent.ParentComponentOptions;
public class DocumentOptions {
    private final ParentComponentOptions parentComponentOptions;

    private final WebDocumentOptions webDocumentOptions;

    public DocumentOptions() {
        this.parentComponentOptions = new ParentComponentOptions();
        this.webDocumentOptions = new WebDocumentOptions();
        parentComponentOptions.setTagName("html");
    }

    public ParentComponentOptions getParentComponentOptions() {
        return this.parentComponentOptions;
    }

    public WebDocumentOptions getWebDocumentOptions() {
        return this.webDocumentOptions;
    }

    /**
     * Gets the document title
     *
     * @return Title
     */
    public String getTitle() {
        return webDocumentOptions.getTitle();
    }

    /**
     * Sets the document title
     *
     * @param title:
     * 		Title
     * @return Options instance
     */
    public DocumentOptions setTitle(String title) {
        webDocumentOptions.setTitle(title);
        return this;
    }
}