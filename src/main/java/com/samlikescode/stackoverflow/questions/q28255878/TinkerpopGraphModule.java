package com.samlikescode.stackoverflow.questions.q28255878;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.io.IOException;

public class TinkerpopGraphModule extends SimpleModule {
    private static final String NAME = "TinkerpopGraphModule";

    public TinkerpopGraphModule() {
        super(NAME);
        addSerializer(TinkerGraph.class, new TinkerpopGraphSerializer());
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
    }

    public static class TinkerpopGraphSerializer extends JsonSerializer<TinkerGraph> {
        @Override
        public void serialize(TinkerGraph graph, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            DefaultPrettyPrinter.Indenter indenter = new DefaultIndenter("    ", DefaultIndenter.SYS_LF);
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
            printer.indentObjectsWith(indenter);
            printer.indentArraysWith(indenter);
            jsonGenerator.setPrettyPrinter(printer);
        }
    }
}
