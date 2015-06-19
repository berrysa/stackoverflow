package com.samlikescode.stackoverflow.questions.q29845416;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

/**
 * //todo(sb)
 */
public class CustomObjectTest {

    @Test
    public void testDoctypeAttribute() throws Exception {
        CustomObject customObject = new CustomObject();
        customObject.attribute = "attr";

    XmlMapper xm = new XmlMapper();
//    xm.registerModule(new GsaFeedModule());

        String xml = xm.writeValueAsString(customObject);

        System.out.println(xml);
    }
}
