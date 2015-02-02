package com.samlikescode.stackoverflow.questions.q28255878;

import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ObjectMapperConfigurationModule extends SimpleModule {
    private static final String NAME = "ObjectMapperConfigurationModule";
    private static final VersionUtil VERSION_UTIL = new VersionUtil() { };

    public ObjectMapperConfigurationModule() {
        super(NAME, VERSION_UTIL.version());
    }

    @Override
    public void setupModule(SetupContext context) {
        ObjectMapper mapper = context.getOwner();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new TinkerpopGraphModule());
    }
}
