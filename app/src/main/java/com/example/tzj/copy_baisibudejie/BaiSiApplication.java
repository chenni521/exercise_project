package com.example.tzj.copy_baisibudejie;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by tzj on 2017/6/8.
 */

public class BaiSiApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
    }

}
