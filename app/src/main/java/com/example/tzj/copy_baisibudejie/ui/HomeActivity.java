package com.example.tzj.copy_baisibudejie.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.adapter.MyFragmentPagerAdapter;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.example.tzj.copy_baisibudejie.adapter.SideListviewAdapter;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.info_viewpager)
    ViewPager infoViewpager;
    @BindView(R.id.content_frame)
    FrameLayout contentFrame;
    @BindView(R.id.left_drawer)
    ListView leftDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.title_left_topView)
    View titleLeftTopView;


    @Override
    public void initData() {
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        infoViewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), HomeActivity.this));
        tabLayout.setupWithViewPager(infoViewpager);
//        leftDrawer.setAdapter(new SideListviewAdapter(HomeActivity.this));
        setTransparent(titleLeftTopView);
    }


    @Override
    public void initOnClick() {
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_home;
    }


    public class Contributor {
        private String login;
        private Integer contributions;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Integer getContributions() {
            return contributions;
        }

        public void setContributions(Integer contributions) {
            this.contributions = contributions;
        }
    }

}
