package com.samlikescode.stackoverflow.questions.q31264303;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;

/**
 * //todo(sb)
 */
public class AnimalDeserializerTest {
    @Test
    public void testDeserialization() throws Exception {
        ObjectMapper om = new ObjectMapper();
        JsonNode node = om.readTree(new File("/Users/berrysa/projects/stackoverflow/src/main/java/com/samlikescode/stackoverflow/questions/q31264303/animalObject.json"));
        JsonToken jsonToken = node.asToken();
        if (jsonToken.isStructStart()) {

        }
    }

    @Test
    public void testTest() throws Exception {
        String s = "{ \"id\":123456, \"food\":\"biscuit\", \"comment\":\"black with white pows\" }";

        File animalObjectJson = new File("/Users/berrysa/projects/stackoverflow/src/main/java/com/samlikescode/stackoverflow/questions/q31264303/animalObject.json");
        ObjectMapper om = new ObjectMapper();
        Animal animal = om.readValue(s, Animal.class);


        System.out.println(animal);
    }

    @Test
    public void testTest2() throws Exception {
        String s = "{\n" +
                "    \"animals\": [\n" +
                "        {\n" +
                "            \"id\":123456\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\":987654\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";

        ObjectMapper om = new ObjectMapper();
        Zoo zoo = om.readValue(s, Zoo.class);

        System.out.println(zoo);
    }
}
