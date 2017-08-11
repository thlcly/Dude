package com.aaront.telegram.bot.response.express;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@Data
public class TraceVO {
    @JsonProperty("AcceptTime")
    private String acceptTime;
    @JsonProperty("AcceptStation")
    private String acceptStation;
    @JsonProperty("Remark")
    private String remark;
}
