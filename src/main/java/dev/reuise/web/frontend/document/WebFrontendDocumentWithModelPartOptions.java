package dev.reuise.web.frontend.document;
import akasha.Element;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import dev.reuise.core.State;
import dev.reuise.core.option.ComponentOption;
import dev.reuise.web.frontend.WebFrontendComponentFactory;
public interface WebFrontendDocumentWithModelPartOptions<M> {
    WebFrontendDocumentPartOptions getDocumentPart();

    ObjectMapper<M> getModelMapper();

    ComponentOption<ObjectMapper<M>> getModelMapperOption();

    WebFrontendDocumentWithModelPartOptions setModelMapper(ObjectMapper<M> modelMapper);

    <T> void setDefaultOption(String option, T value);

    <T> void setDefaultOption(String option, T value, boolean force);

    <T> void setDefaultOption(String option, T value, State state);

    <T> void setDefaultOption(String option, T value, State state, boolean force);

    boolean rehydrate(Element element);

    WebFrontendComponentFactory getComponentFactory();

    WebFrontendDocumentWithModel getComponent();
}
