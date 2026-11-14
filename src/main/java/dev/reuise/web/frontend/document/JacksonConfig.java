package dev.reuise.web.frontend.document;

import java.time.LocalDateTime;

import com.github.nmorel.gwtjackson.client.AbstractConfiguration;

public class JacksonConfig extends AbstractConfiguration {
	@Override
	protected void configure() {
		type(LocalDateTime.class).deserializer(LocalDateTimeDeserializer.class);
	}
}
