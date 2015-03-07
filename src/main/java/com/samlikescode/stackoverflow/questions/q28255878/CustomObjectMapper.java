package com.samlikescode.stackoverflow.questions.q28255878;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinkerpop.gremlin.structure.io.graphson.GraphSONModule;

import java.io.IOException;

/**
 * //todo(sb)
 */
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper(boolean normalize) {
        super();
        registerModule(new GraphSONModule(normalize));
    }



    @Override
    public void writeValue(JsonGenerator jgen, Object value) throws IOException, JsonGenerationException, JsonMappingException {
        DefaultPrettyPrinter.Indenter indenter = new DefaultIndenter("    ", DefaultIndenter.SYS_LF);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer.indentObjectsWith(indenter);
        printer.indentArraysWith(indenter);
        jgen.setPrettyPrinter(printer);
        super.writeValue(jgen, value);
    }
}
