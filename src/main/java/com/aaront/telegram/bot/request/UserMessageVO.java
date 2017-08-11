package com.aaront.telegram.bot.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@Data
public class UserMessageVO {
    @JsonProperty("update_id")
    private Integer updateId;
    private Message message;
}
