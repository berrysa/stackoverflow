package com.samlikescode.jsonassert;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONAssertTest {
    @Test
    public void testJsonAssert() throws Exception {
        Customization customization = new Customization("id", (left, right) -> right != null && right instanceof Integer);

        String actual = new String(Files.readAllBytes(Paths.get("/Users/berrysa/projects/stackoverflow/src/test/java/com/samlikescode/jsonassert/idMisMatchResult.json")));
        String expected = new String(Files.readAllBytes(Paths.get("/Users/berrysa/projects/stackoverflow/src/test/java/com/samlikescode/jsonassert/idMisMatchExpected.json")));

        JSONAssert.assertEquals(expected, actual, new CustomComparator(JSONCompareMode.STRICT, customization));
    }

    public void testJson(String expected, String result, Customization... customizations) throws JSONException {
        JSONAssert.assertEquals(expected, result, new CustomComparator(JSONCompareMode.STRICT, customizations));
    }

    private static class Customizations {
//        public static ValueMatcher integerMatcher = new CustomComparator()
    }
}
