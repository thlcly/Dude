package com.aaront.telegram.bot.config;

import com.aaront.telegram.bot.api.KdniaoApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.Map;

@Configuration
@AutoConfigureAfter(JacksonAutoConfiguration.class)
public class KdniaoRetrofitConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${kdniao.host}")
    private String kdniaoHost;

    @Bean
    public KdniaoApi kdniaoApi(){
        return _retrofit().create(KdniaoApi.class);
    }

    private Retrofit _retrofit(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor((chain) -> {
            // 设置通用的请求属性
            Map<String, String> map = Maps.newHashMap();
            map.put("accept", "*/*");
            map.put("connection", "Keep-Alive");
            map.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            map.put("Content-Type", "application/x-www-form-urlencoded");
            Request original = chain.request();
            Request request = original.newBuilder().headers(Headers.of(map)).build();
            return chain.proceed(request);
        });
        return new Retrofit.Builder()
                .baseUrl(kdniaoHost)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(httpClient.build())
                .build();
    }

}