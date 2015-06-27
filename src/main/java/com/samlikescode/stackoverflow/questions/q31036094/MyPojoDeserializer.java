package com.samlikescode.stackoverflow.questions.q31036094;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

/**
 * //todo(sb)
 */
public class MyPojoDeserializer extends JsonDeserializer<MyPojo> {
//    private final JsonDeserializer<Object> defaultDeserializer;
//
//    public MyPojoDeserializer(JsonDeserializer<Object> defaultDeserializer) {
//        this.defaultDeserializer = checkNotNull(defaultDeserializer);
//    }

    @Override
    public MyPojo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        List<Integer> keys = Lists.newArrayList();

        String nextFieldName = p.nextFieldName();
        if (nextFieldName != null && nextFieldName.matches("^key[0-9]+")) {
            Integer currentValue = (Integer) p.getCurrentValue();
            keys.add(currentValue);
        } else {
//            p.getCodec().
        }

        return null;
    }
}
