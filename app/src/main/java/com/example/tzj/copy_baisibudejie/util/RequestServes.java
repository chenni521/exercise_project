package com.example.tzj.copy_baisibudejie.util;

import com.example.tzj.copy_baisibudejie.entity.Bean1;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by tzj on 2017/5/22.
 */

public interface RequestServes {
    @GET("repos/{owner}/{repo}/contributors")
    Call<ResponseBody> contributorsBySimpleGetCall(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/op2/promotion/budejie-android-6.7.2-tencentyingyongbao/0-20.json?market=tencentyingyongbao&udid=864394010288340&appname=baisibudejie&os=4.4.2&client=android&visiting=&mac=1C%3A83%3A41%3A13%3A80%3A8E&ver=6.7.2")
    Call<Bean1> testHttpGet();

    @FormUrlEncoded
    @POST("/op2/promotion/budejie-android-6.7.2-tencentyingyongbao/0-20.json")
    Call<String> testHttpPost(@Field("market") String market
            , @Field("udid") String udid
            , @Field("appname") String appname
            , @Field("os") String os
            , @Field("client") String client
            , @Field("visiting") String visiting
            , @Field("mac") String mac
            , @Field("ver") String ver
    );



}
