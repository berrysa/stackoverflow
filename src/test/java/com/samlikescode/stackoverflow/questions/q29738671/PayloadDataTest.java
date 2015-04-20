package com.samlikescode.stackoverflow.questions.q29738671;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * //todo(sb)
 */
public class PayloadDataTest {

    /*
    {
    "xmlns": {
       "nskey1" : "nsurl1",
       "nskey2" : "nsurl2"
    },

    "datakey1": "datavalue1",
    "datakey2": "datavalue2"
    }
     */
    @Test
    public void testPayloadSerialization() throws Exception {
        Map<NamespaceEnum, String> namespaces = new TreeMap<>();
        namespaces.put(NamespaceEnum.NS_KEY_1, "nsurl1");
        namespaces.put(NamespaceEnum.NS_KEY_2, "nsurl2");

        Map<String, String> payloadData = new TreeMap<String, String>();
        payloadData.put("datakey1", "datavalue1");
        payloadData.put("datakey2", "datavalue2");

        PayloadData data = new PayloadData(namespaces, payloadData);

        ObjectMapper om = new ObjectMapper();

        String json = om.writeValueAsString(data);

        System.out.println(json);
    }
}
