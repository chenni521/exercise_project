package com.example.tzj.copy_baisibudejie.util.progress;

import android.os.Handler;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.example.tzj.copy_baisibudejie.util.LogUtil;

import java.io.InputStream;

public class ProgressModelLoader implements StreamModelLoader<String> {

    private Handler handler;

    public ProgressModelLoader(Handler handler) {
        this.handler = handler;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(String model, int width, int height) {
//        LogUtil.e(model);
//        LogUtil.e(width+"");
//        LogUtil.e(height+"");
        return new ProgressDataFetcher(model, handler);
    }

}
