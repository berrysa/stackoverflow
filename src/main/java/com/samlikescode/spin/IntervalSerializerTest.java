package com.samlikescode.spin;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class IntervalSerializerTest {
  private static final CustomObjectMapper OBJECT_MAPPER =
          new CustomObjectMapper();

  @Test
  public void testIntervalSerialization() throws Exception {
    DateTime startDate = DateTime.parse("2010-01-20");
    DateTime endDate = DateTime.parse("2015-09-25");
    Interval interval = new Interval(startDate, endDate);

    String result = OBJECT_MAPPER.writeValueAsString(interval);
    String expected = new String(Files.readAllBytes(Paths.get("interval.json")));

    assertEquals(expected, result);
  }
}