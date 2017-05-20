package com.example.tzj.copy_baisibudejie.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.ui.basa.BasaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BasaActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.info_viewpager)
    ViewPager infoViewpager;
    private String[] titles = {"推荐", "视频", "图片", "段子", "排行", "互动区", "网红", "社会", "投票", "美女", "冷知识", "游戏"};//头部标签

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
    }


}
