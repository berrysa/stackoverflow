package com.samlikescode.stackoverflow.questions.q29738671;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PayloadData {
    private final Map<String, String> payloadData;
    private final Map<NamespaceEnum, String> namespaces;

    @JsonCreator
    public PayloadData(@JsonProperty("xmlns") Map<NamespaceEnum, String> namespaces,
                       @JsonProperty("payloadData") Map<String, String> payloadData) {
        this.namespaces = namespaces;
        this.payloadData = payloadData;
    }

    @JsonAnyGetter
    public Map<String, String> getPayloadData() {
        return payloadData;
    }

    @JsonProperty("xmlns")
    public Map<NamespaceEnum, String> getNamespaces() {
        return namespaces;
    }
}
