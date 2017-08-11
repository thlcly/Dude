package com.aaront.telegram.bot.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@Data
public class User {
    private Integer id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private Optional<String> lastName = Optional.empty();
    private Optional<String> username = Optional.empty();
    @JsonProperty("language_code")
    private Optional<String> languageCode = Optional.empty();
}
