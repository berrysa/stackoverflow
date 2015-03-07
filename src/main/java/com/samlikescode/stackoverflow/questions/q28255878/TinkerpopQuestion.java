package com.samlikescode.stackoverflow.questions.q28255878;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinkerpop.gremlin.structure.Graph;
import com.tinkerpop.gremlin.structure.Vertex;
import com.tinkerpop.gremlin.structure.io.graphson.GraphSONMapper;
import com.tinkerpop.gremlin.structure.io.graphson.GraphSONWriter;
import com.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.io.IOException;

public class TinkerpopQuestion {
    public static void main(String... args) throws IOException {
        Graph graph = TinkerGraph.open();
        Vertex marko = graph.addVertex("name","marko","age",29);
        Vertex lop = graph.addVertex("name","lop","lang","java");
        marko.addEdge("created",lop,"weight",0.6d);

        GraphSONMapper mapper = GraphSONMapper.build()
                .addCustomModule(new ObjectMapperConfigurationModule())
//                .addCustomModule(new TinkerpopGraphModule())
                .create();
        GraphSONWriter writer = graph.io().graphSONWriter().mapper(mapper).create();
        writer.writeGraph(System.out, graph);

        CustomObjectMapper com = new CustomObjectMapper(false);
        String json = com.writeValueAsString(graph);
        System.out.println(json);
    }

    private void prettyPrinter() {
        DefaultPrettyPrinter.Indenter indenter =
                new DefaultIndenter("    ", DefaultIndenter.SYS_LF);
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer.indentObjectsWith(indenter);
        printer.indentArraysWith(indenter);
        ObjectMapper om = new ObjectMapper();
        om.writer(printer);
    }
}
