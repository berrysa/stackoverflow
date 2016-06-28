package com.samlikescode.spin;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;

public class IntervalSerializer extends JsonSerializer<Interval> {
  private static final DateTimeFormatter DATE_FORMATTER =
          ISODateTimeFormat.date();

  @Override
  public void serialize(Interval interval,
                        JsonGenerator jsonGenerator,
                        SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("start", interval.getStart().toString(DATE_FORMATTER));
    jsonGenerator.writeStringField("end", interval.getEnd().toString(DATE_FORMATTER));
    jsonGenerator.writeEndObject();
  }
}
