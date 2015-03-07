package com.samlikescode.stackoverflow.questions.q28514264;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * //todo(sb)
 */
public class CustomModule extends SimpleModule {
    private static final String NAME = "CustomModule";

    public CustomModule() {
        super(NAME);
    }

//    private static class CustomDeserializer implements StdDeserializer<ResponseClass> {
//
//    }
}