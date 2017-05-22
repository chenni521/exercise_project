package com.example.tzj.copy_baisibudejie.util;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by tzj on 2017/5/22.
 */

public interface RequestServes {
    @GET("getUnitaryAnnouncedList.php")
    Call<ResponseInfo> testHttpGet();

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


    class ResponseInfo {
        String describe;
    }
}
