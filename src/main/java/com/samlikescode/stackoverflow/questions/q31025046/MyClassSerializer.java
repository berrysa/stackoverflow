package com.samlikescode.stackoverflow.questions.q31025046;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * //todo(sb)
 */
public class MyClassSerializer extends JsonSerializer<MyClass> {
    private final JsonSerializer<Object> defaultSerializer;

    public MyClassSerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = checkNotNull(defaultSerializer);
    }

    @Override
    public void serialize(MyClass myclass, JsonGenerator gen, SerializerProvider provider) throws IOException {
        defaultSerializer.serialize(myclass, gen, provider);
    }
}
