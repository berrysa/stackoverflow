package com.samlikescode.stackoverflow.questions.q24157817;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class DataTypeTest {
    private static final String HTML_KEY = DataType.HTML.getKey();

    @Test
    public void testLowerCaseString() throws Exception {
        String html = "html";

        DataType result = DataType.fromString(html);
        assertEquals(DataType.HTML, result);
    }

    @Test
    public void testNullReturnedForNull() throws Exception {
        String theNull = null;

        DataType result = DataType.fromString(theNull);
        assertNull(result);
    }

    @Test
    public void testListSerialization() throws Exception {
        Collection<DataType> collection = new ArrayList<>();
        collection.add(DataType.HTML);

        ObjectMapper om = new ObjectMapper();
        String stringValue = om.writeValueAsString(collection);

        assertEquals(HTML_KEY, om.readTree(stringValue).get(0).asText());
    }

    @Test
    public void testSetSerialization() throws Exception {
        HashSet<DataType> collection = new HashSet<>();
        collection.add(DataType.HTML);

        ObjectMapper om = new ObjectMapper();
        String stringValue = om.writeValueAsString(collection);

        assertEquals(HTML_KEY, om.readTree(stringValue).get(0).asText());
    }
}
