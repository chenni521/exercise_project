package com.example.tzj.copy_baisibudejie.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    @BindView(R.id.content_video_name)
    TextView contentVideoName;
    @BindView(R.id.title_left_topView)
    View titleLeftTopView;

    private String mVideoUrl = "";
    private String content = "";

    @Override
    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mVideoUrl = intent.getStringExtra("url");
            content = intent.getStringExtra("content");
        }
        if (mVideoUrl != null && !mVideoUrl.equals("")) {
            vp.setTitle(content);
            vp.loadAndStartVideo(this, mVideoUrl);
        }

        contentVideoName.setText(content);
        setTransparent(titleLeftTopView);
    }

    @Override
    public void initOnClick() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.video_layout;
    }


}
