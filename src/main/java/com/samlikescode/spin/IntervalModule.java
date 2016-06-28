package com.samlikescode.spin;

import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.time.Interval;

public class IntervalModule extends SimpleModule {
  private static final String NAME = "CustomIntervalModule";
  private static final VersionUtil VERSION_UTIL = new VersionUtil() {};

  public IntervalModule() {
    super(NAME, VERSION_UTIL.version());
    addSerializer(Interval.class, new IntervalSerializer());
  }
}
