package com.aaront.telegram.bot.api;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
public interface KdniaoApi {

    @POST(value = "EbusinessOrderHandle.aspx")
    @FormUrlEncoded
    Call<String> queryExpress(@FieldMap Map<String, String> params);

}
