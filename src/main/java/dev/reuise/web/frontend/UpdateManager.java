package dev.reuise.web.frontend;

import com.github.nmorel.gwtjackson.client.ObjectMapper;

import dev.reuise.core.AbstractUpdateManager;

public class UpdateManager<T> extends AbstractUpdateManager<T> {
    private ObjectMapper<T> objectMapper;

    public UpdateManager(ObjectMapper<T> objectMapper, T initialState) {
        super(initialState);
        this.objectMapper = objectMapper;
    }

    public static <T> UpdateManager<T> create(ObjectMapper<T> mapper) {
        return create(mapper, null);
    }

    public static <T> UpdateManager<T> create(ObjectMapper<T> mapper, T initialState) {
        return new UpdateManager<>(mapper, initialState);
    }

    protected T deepCopy(T object) throws Exception {
        return objectMapper.read(objectMapper.write(object));
    }
}
