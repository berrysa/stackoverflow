package com.samlikescode.stackoverflow.questions.q29738671;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NamespaceEnum {
    NS_KEY_1("nskey1"),
    NS_KEY_2("nskey2");

    private String key;

    private NamespaceEnum(String key) {
        this.key = key;
    }

    @JsonValue
    public String getKey() {
        return key;
    }
}
