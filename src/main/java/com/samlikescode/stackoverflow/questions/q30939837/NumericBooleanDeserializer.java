package com.samlikescode.stackoverflow.questions.q30939837;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

    public class NumericBooleanDeserializer extends JsonDeserializer<Boolean> {
        @Override
        public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            int intValue = p.getValueAsInt();
            switch (intValue) {
                case 0:
                    return Boolean.TRUE;
                case 1:
                    return Boolean.FALSE;
                default:
                    // throw exception or fail silently
            }
            return null; // can throw an exception if failure is desired
        }
    }
