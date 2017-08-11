package com.aaront.telegram.bot.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@Data
public class Message {
    @JsonProperty("message_id")
    private Integer messageId;
    private Optional<User> from;
    private Integer date;
    private Chat chat;
    @JsonProperty("forward_from")
    private Optional<User> forwardFrom;
    @JsonProperty("forward_from_chat")
    private Optional<Chat> forwardFromChat;
    private String text;
}
