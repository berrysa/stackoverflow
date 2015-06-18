package com.samlikescode.stackoverflow.questions.q29845416;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * //todo(sb)
 */
public class CustomObjectModule extends SimpleModule {
    private static final String NAME = "CustomObjectModule";

    public CustomObjectModule() {
        super(NAME);
        addSerializer(CustomObject.class, new CustomObjectSerializer());
    }

    public static class CustomObjectSerializer extends JsonSerializer<CustomObject> {
        @Override
        public void serialize(CustomObject customObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeRaw("<!DOCTYPE myCustomMetaData>");
            jsonGenerator.writeStartObject();
            // write fields
            jsonGenerator.writeEndObject();
        }
    }

}
