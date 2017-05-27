package com.example.tzj.copy_baisibudejie.util;

import com.example.tzj.copy_baisibudejie.entity.Bean1;
import com.example.tzj.copy_baisibudejie.entity.RecommendVo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by tzj on 2017/5/22.
 */

public interface RequestServes {


    @FormUrlEncoded
    @POST("/op2/promotion/budejie-android-6.7.2-tencentyingyongbao/0-20.json")
    Call<Bean1> headerHttpPost(@Field("market") String market
            , @Field("udid") String udid
            , @Field("appname") String appname
            , @Field("os") String os
            , @Field("client") String client
            , @Field("visiting") String visiting
            , @Field("mac") String mac
            , @Field("ver") String ver
    );

    @FormUrlEncoded
    @POST("topic/list/jingxuan/1/budejie-android-6.7.2/{firstPositon}-{lastPosition}.json")
    Call<RecommendVo> recommendHttpPost(
            @Path("firstPositon") long firstPositon,
            @Path("lastPosition") int lastPosition,
            @Field("market") String market
            , @Field("udid") String udid
            , @Field("appname") String appname
            , @Field("os") String os
            , @Field("client") String client
            , @Field("visiting") String visiting
            , @Field("mac") String mac
            , @Field("ver") String ver
    );
}
