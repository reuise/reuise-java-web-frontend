package dev.reuise.web.frontend.document;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
public interface WebFrontendDocumentWithModelFeatures<M> {
    ObjectMapper<M> getModelMapper();

    WebFrontendDocumentWithModelFeatures setModelMapper(ObjectMapper<M> modelMapper);
}
