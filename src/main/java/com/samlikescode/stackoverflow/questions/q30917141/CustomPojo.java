package com.samlikescode.stackoverflow.questions.q30917141;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

    public class CustomPojo {
        private final Integer keyToKeep;
        private final String keyToRemove;

        @JsonCreator
        public CustomPojo(@JsonProperty("Lorem Ipsum ") Integer keyToKeep,
                          @JsonProperty("keyToRemove") String keyToRemove) {
            this.keyToKeep = keyToKeep;
            this.keyToRemove = keyToRemove;
        }

        @JsonProperty("Lorem Ipsum ")
        public Integer getKeyToKeep() {
            return keyToKeep;
        }

        @JsonProperty("keyToRemove")
        public String getKeyToRemove() {
            return keyToRemove;
        }
    }
