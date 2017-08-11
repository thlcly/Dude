package com.aaront.telegram.bot.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class MessageReplyVO {
    @JsonProperty("chat_id")
    private String chatId;
    private String text;
    @JsonProperty("parse_mode")
    private Optional<String> parseMode;
    @JsonProperty("disable_web_page_preview")
    private Optional<Boolean> disableWebPagePreview;
    @JsonProperty("disable_notification")
    private Optional<Boolean> disableNotification;
    @JsonProperty("reply_to_message_id")
    private Optional<Integer> replyToMessageId;
    private String method;
    // TODO: 2017/8/11 后续支持
    // reply_markup
}
