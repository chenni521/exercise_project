package com.example.tzj.copy_baisibudejie.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;

import org.lynxz.zzplayerlibrary.widget.VideoPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by psj on 2017/5/23.
 */

public class VideoActivity extends BaseActivity {

    @BindView(R.id.vp)
    VideoPlayer vp;

    private String mVideoUrl = "";

    @Override
    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mVideoUrl = intent.getStringExtra("url");
        }
        if (mVideoUrl != null && !mVideoUrl.equals("")) {
            vp.loadAndStartVideo(this, mVideoUrl);
        }
    }

    @Override
    public void initOnClick() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.video_layout;
    }


}
