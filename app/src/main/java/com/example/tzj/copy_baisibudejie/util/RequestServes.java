package com.example.tzj.copy_baisibudejie.util;

import com.example.tzj.copy_baisibudejie.entity.HeaderBena;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by tzj on 2017/5/22.
 */

public interface RequestServes {
    @FormUrlEncoded
    @POST("/op2/promotion/budejie-android-6.7.2-tencentyingyongbao/0-20.json")
    Call<HeaderBena> headerHttpPost(@Field("market") String market
            , @Field("udid") String udid
            , @Field("appname") String appname
            , @Field("os") String os
            , @Field("client") String client
            , @Field("visiting") String visiting
            , @Field("mac") String mac
            , @Field("ver") String ver
    );
    @FormUrlEncoded
    @POST("topic/list/jingxuan/1/budejie-android-6.7.2/0-20.json")
    Call<HeaderBena> recommendHttpPost(@Field("market") String market
            , @Field("udid") String udid
            , @Field("appname") String appname
            , @Field("os") String os
            , @Field("client") String client
            , @Field("visiting") String visiting
            , @Field("mac") String mac
            , @Field("ver") String ver
    );
}
