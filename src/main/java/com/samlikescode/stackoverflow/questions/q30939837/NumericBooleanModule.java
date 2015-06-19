package com.samlikescode.stackoverflow.questions.q30939837;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.samlikescode.stackoverflow.questions.q29845416.CustomObject;

import java.io.IOException;

/**
 * //todo(sb)
 */
public class NumericBooleanModule extends SimpleModule {
    private static final String NAME = "NumericBooleanModule";

    public NumericBooleanModule() {
        super(NAME);
        addSerializer(CustomObject.class, new NumericBooleanSerializer());
    }

    public static class NumericBooleanSerializer extends JsonSerializer<CustomObject> {
        @Override
        public void serialize(CustomObject customObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeRaw("<!DOCTYPE myCustomMetaData>");
            jsonGenerator.writeStartObject();
            // write fields
            jsonGenerator.writeEndObject();
        }
    }
}
