package dev.reuise.web.frontend.document;

import java.time.LocalDateTime;
import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonDeserializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;
import com.github.nmorel.gwtjackson.client.stream.JsonToken;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    private static final LocalDateTimeDeserializer INSTANCE = new LocalDateTimeDeserializer();

    public static LocalDateTimeDeserializer getInstance() {
        return INSTANCE;
    }

    private LocalDateTimeDeserializer() {
    }

    @Override
    protected LocalDateTime doDeserialize(JsonReader reader, JsonDeserializationContext ctx,
            JsonDeserializerParameters params) {
        if (reader.peek() == JsonToken.STRING) {
            String string = reader.nextString().trim();
            if (string.length() == 0) {
                return null;
            }

            return LocalDateTime.parse(string);
        } else {

            if (reader.peek() == JsonToken.END_ARRAY) {
                return null;
            }
            int year = reader.nextInt();
            int month = reader.nextInt();
            int day = reader.nextInt();
            int hour = reader.nextInt();
            int minute = reader.nextInt();

            if (reader.peek() != JsonToken.END_ARRAY) {
                int second = reader.nextInt();
                return LocalDateTime.of(year, month, day, hour, minute, second);
            }
            return LocalDateTime.of(year, month, day, hour, minute);
        }
    }
}

