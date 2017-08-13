package com.aaront.telegram.bot.config;

import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.validation.constraints.NotNull;

public class CustomEnumModule extends SimpleModule {
    public CustomEnumModule(@NotNull String prop) {
        this.addDeserializer(Enum.class, new CustomEnumDeserializer(prop));
        this.addSerializer(Enum.class, new CustomEnumSerializer(prop));
    }
}