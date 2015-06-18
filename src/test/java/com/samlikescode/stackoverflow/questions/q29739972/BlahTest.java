package com.samlikescode.stackoverflow.questions.q29739972;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * //todo(sb)
 */
public class BlahTest {
    @Test
    public void serializingAnObjectToJson() throws Exception {
        // Create an object mapper. This maps objects to json/xml/etc using Jackson.
        ObjectMapper om = new ObjectMapper();

        MyPoint point = new MyPoint(223l, "Superman");

        // Creates a JSON representation of the object
        String json = om.writeValueAsString(point);

        // Create a JAX-RS response with the JSON as the body
        Response response = Response.ok(json).build();
    }

    private static class MyPoint {
        private Long Id;

        private String name;

        private MyPoint(Long id, String name) {
            Id = id;
            this.name = name;
        }

        private Long getId() {
            return Id;
        }

        private String getName() {
            return name;
        }
    }
}
