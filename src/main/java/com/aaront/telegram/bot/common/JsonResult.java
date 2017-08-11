package com.aaront.telegram.bot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

import static com.aaront.telegram.bot.common.ApiError.GENERAL_ERR;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class JsonResult {

    private Boolean success = false;

    private Object data;

    private Optional<Integer> errorCode;

    private Optional<String> errorMessage;

    public static JsonResult ok() {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        return result;
    }

    public static JsonResult ok(Object data) {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static JsonResult error(ApiError apiError) {
        return error(apiError.getCode(), apiError.getMessage());
    }

    public static JsonResult error(String message) {
        return error(GENERAL_ERR.getCode(), message);
    }

    public static JsonResult error(Integer errorCode, String message) {
        JsonResult result = new JsonResult();
        result.setErrorCode(Optional.of(errorCode));
        result.setErrorMessage(Optional.ofNullable(message));
        return result;
    }

    public static JsonResult error() {
        return error(GENERAL_ERR);
    }
}