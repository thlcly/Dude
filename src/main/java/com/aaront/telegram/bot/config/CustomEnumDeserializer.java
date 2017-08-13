package com.aaront.telegram.bot.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.stream.Stream;

public class CustomEnumDeserializer extends JsonDeserializer<Enum> implements ContextualDeserializer {

    @Setter
    private Class<Enum> enumCls;

    private String prop;

    /**
     * @param prop 属性名
     */
    public CustomEnumDeserializer(@NotNull String prop) {
        this.prop = prop;
    }

    @Override
    public Enum deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
        String text = parser.getText();
        return Enums.getEnum(enumCls, prop, text).orElseGet(() ->
                                                                    Stream.of(enumCls.getEnumConstants())
                                                                            .filter(e -> e.name().equals(text))
                                                                            .findFirst().orElse(null)
        );
    }

    @Override
    public JsonDeserializer createContextual(DeserializationContext ctx, BeanProperty property) throws JsonMappingException {
        Class rawCls = ctx.getContextualType().getRawClass();

        Class<Enum> enumCls = (Class<Enum>) rawCls;
        CustomEnumDeserializer clone = new CustomEnumDeserializer(prop);
        clone.setEnumCls(enumCls);
        return clone;
    }
}