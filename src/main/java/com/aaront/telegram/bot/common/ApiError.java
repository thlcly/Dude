package com.aaront.telegram.bot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiError {

    // 系统错误
    GENERAL_ERR(0, "服务异常"),
    GENERAL_JSON_CONVERT_ERR(1, "数据格式错误"),

    // 通用错误
    GENERAL_RESOURCE_NOEXIST(10, "资源不存在"),
    GENERAL_INVALID_PARAMS(11, "请求参数错误"),
    GENERAL_NO_PERMISSION(12, "没有权限");

    private int code;
    private String message;
}