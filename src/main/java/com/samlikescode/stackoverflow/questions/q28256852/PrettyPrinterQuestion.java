package com.samlikescode.stackoverflow.questions.q28256852;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * //todo(sb)
 */
public class PrettyPrinterQuestion {


    public static void main(String... args) throws JsonProcessingException, NoSuchFieldException, IllegalAccessException {
        // Create the mapper
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter.Indenter indenter = new DefaultIndenter("   ", DefaultIndenter.SYS_LF);
        printer.indentObjectsWith(indenter);
        printer.indentArraysWith(indenter);


        Field field = ObjectMapper.class.getDeclaredField("_defaultPrettyPrinter");
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, printer);

        // Setup a pretty printer with an indenter (indenter has 4 spaces in this case)

        // Some object to serialize
        Map<String, Object> value = new HashMap<>();
        value.put("foo", Arrays.asList("a", "b", "c"));
        value.put("aString", "stringy");

        ObjectMapper mapper = new ObjectMapper();
        // Serialize it using the custom printer
        String json = mapper.writeValueAsString(value);

        // Print it
        System.out.println(json);
    }
}
