package com.samlikescode.stackoverflow.questions.q31025046;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * //todo(sb)
 */
public class MySpecificClassSerializer extends JsonSerializer<MySpecificClass> {
    private final JsonSerializer<Object> defaultSerializer;

    public MySpecificClassSerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = checkNotNull(defaultSerializer);
    }

    @Override
    public void serialize(MySpecificClass value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        defaultSerializer.serialize(value, gen, serializers);
    }

    @Override
    public boolean isEmpty(SerializerProvider provider, MySpecificClass value) {
        return value.id == null;
    }
}
