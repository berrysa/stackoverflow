package com.samlikescode.stackoverflow.questions.q13161752;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * //todo(sb)
 */
public class PrimitiveSerializationTest {

    @Test
    public void testNullPrimitive() throws Exception {
        ObjectMapper om = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
    }
}
