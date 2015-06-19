package com.samlikescode.stackoverflow.questions.q30939837;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * //todo(sb)
 */
public class UserDeserializationTest {
    @Test
    public void testDeserialization() throws IOException {
        ObjectMapper om = new ObjectMapper();

        JsonParser jp = new JsonFactory().createParser(new File("/Users/berrysa/projects/stackoverflow/src/main/java/com/samlikescode/stackoverflow/questions/q30939837/input.json"));

        User user = om.readValue(jp, User.class);
        System.out.println(user);
    }
}
