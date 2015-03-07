package com.samlikescode.stackoverflow.questions.q28514264;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * //todo(sb)
 */
public class ResponseTest {
    @Test
    public void testDoubleResponseType() throws IOException {
        ImmutableList<String> jsonInputs = ImmutableList.of(
                "{\"result\": \"0\"}",
                "{\"result\": {\"fname\": \"abc\", \"lname\": \"xyz\"}}"
        );

        ObjectMapper om = new ObjectMapper();

        for (String jsonInput : jsonInputs) {
            JsonNode node = om.readValue(jsonInput, JsonNode.class);
            JsonNode result = node.get("result");
            if (result.isTextual()) {
                assertEquals("0", result.asText());
            } else if (result.isObject()) {
                NameResponse nameResponse = om.readValue(result.toString(), NameResponse.class);
                assertEquals(new NameResponse("abc", "xyz"), nameResponse);
            } else {
                fail();
            }
        }
    }

    public static class NameResponse {
        private final String fname;
        private final String lname;

        @JsonCreator
        public NameResponse(@JsonProperty("fname") String fname,
                            @JsonProperty("lname") String lname) {
            this.fname = fname;
            this.lname = lname;
        }

        public String getFname() {
            return fname;
        }

        public String getLname() {
            return lname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NameResponse that = (NameResponse) o;
            return Objects.equal(this.fname, that.fname)
                    && Objects.equal(this.lname, that.lname);
        }
    }
}
