package com.samlikescode.stackoverflow.questions.q31036094;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.List;

public class KeyDeserializer extends JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return null;
    }
}
