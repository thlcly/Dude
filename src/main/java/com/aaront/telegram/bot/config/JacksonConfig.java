package com.aaront.telegram.bot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingren.jackson.CustomEnumModule;
import com.xingren.jackson.Java8Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class JacksonConfig {

    private static final String ENUM_PROP_NAME = "value";

    @Bean
    public ObjectMapper objectMapper() {
        Java8Mapper java8Mapper = new Java8Mapper();
        // 确保反序列化时自动加上TimeZone信息
        java8Mapper.setTimeZone(TimeZone.getDefault());
        java8Mapper.registerModule(new CustomEnumModule(ENUM_PROP_NAME));

        return java8Mapper;
    }
}