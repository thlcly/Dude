package com.aaront.telegram.bot.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.TimeZone;

public class Java8Mapper extends ObjectMapper {
    public Java8Mapper() {
        this((JsonFactory)null, (DefaultSerializerProvider)null, (DefaultDeserializationContext)null);
    }

    public Java8Mapper(JsonFactory jf) {
        this(jf, (DefaultSerializerProvider)null, (DefaultDeserializationContext)null);
    }

    public Java8Mapper(ObjectMapper src) {
        super(src);
        this.init();
    }

    public Java8Mapper(JsonFactory jf, DefaultSerializerProvider sp, DefaultDeserializationContext dc) {
        super(jf, sp, dc);
        this.init();
    }

    private void init() {
        this.setTimeZone(TimeZone.getDefault());
        this.setSerializationInclusion(JsonInclude.Include.NON_ABSENT).disable(SerializationFeature.FAIL_ON_EMPTY_BEANS).disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
    }
}