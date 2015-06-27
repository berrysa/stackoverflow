package com.samlikescode.stackoverflow.questions.q31036094;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * //todo(sb)
 */
public class MyPojoDerializationTest {


    @Test
    public void testPojoDerialization() throws IOException {
        String input = "{ \"key1\":1, \"key2\":2, \"key3\":3 }";

        ObjectMapper om = new ObjectMapper();

        MyPojo myPojo = om.readValue(input, MyPojo.class);

        assertTrue(myPojo.keys.size() > 1);
    }
}
