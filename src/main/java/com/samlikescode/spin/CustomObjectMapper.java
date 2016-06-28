package com.samlikescode.spin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomObjectMapper extends ObjectMapper {
  public CustomObjectMapper() {
    registerModule(new IntervalModule());
    enable(SerializationFeature.INDENT_OUTPUT);
  }
}
