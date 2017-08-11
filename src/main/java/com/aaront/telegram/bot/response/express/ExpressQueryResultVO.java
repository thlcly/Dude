package com.aaront.telegram.bot.response.express;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@Data
public class ExpressQueryResultVO {
    @JsonProperty("EBusinessID")
    private String eBusinessID;
    @JsonProperty("ShipperCode")
    private String shipperCode;
    @JsonProperty("Success")
    private Boolean success;
    @JsonProperty("LogisticCode")
    private String logisticCode;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Traces")
    private List<TraceVO> traces;
}
