package com.samlikescode.stackoverflow.questions.q31025046;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * //todo(sb)
 */
public class IsEmptySerializationTest {
    @Test
    public void testSerializationNoConfig() throws JsonProcessingException {
        ObjectWriter om = new ObjectMapper().writerWithDefaultPrettyPrinter();
        System.out.println("No Config: " + om.writeValueAsString(getMySpecificClassList()));
    }

    @Test
    public void testSerialization() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper()
                .registerModule(new SimpleModule()
                        .setSerializerModifier(new MyClassSerializerModifier()));

        System.out.println("Config: " + om.writeValueAsString(new MyClassContainer()));
    }

    private List<MySpecificClass> getMySpecificClassList() {
        MySpecificClass myClass = new MySpecificClass();
        myClass.description = "yay a description";
        myClass.id = 123;
        MySpecificClass myEmptyClass = new MySpecificClass();
        myEmptyClass.description = "yay a description";
        myEmptyClass.id = null;
        return Lists.newArrayList(myClass, myEmptyClass);
    }
}
