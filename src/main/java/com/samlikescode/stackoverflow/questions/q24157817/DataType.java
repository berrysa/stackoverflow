package com.samlikescode.stackoverflow.questions.q24157817;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DataType {
    JSON("json"),
    HTML("html");

    private String key;

    DataType(String key) {
        this.key = key;
    }

    @JsonCreator
    public static DataType fromString(String key) {
        return key == null
                ? null
                : DataType.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return key;
    }
}
