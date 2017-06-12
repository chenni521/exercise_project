package com.example.tzj.copy_baisibudejie.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.adapter.MyFragmentPagerAdapter;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.title_left_topView)
    View titleLeftTopView;
    @BindView(R.id.rl_toolbar_image)
    ImageView rlToolbarImage;
    @BindView(R.id.rl_toolbar_textview)
    TextView rlToolbarTextview;
    @BindView(R.id.rl_toolbar_image1)
    ImageView rlToolbarImage1;
    @BindView(R.id.rl_toolbar)
    AutoLinearLayout rlToolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.info_viewpager)
    ViewPager infoViewpager;
    @BindView(R.id.tab_menu_channel)
    TextView tabMenuChannel;
    @BindView(R.id.tab_menu_channe2)
    TextView tabMenuChanne2;
    @BindView(R.id.nav_item_tweet_pub)
    ImageView navItemTweetPub;
    @BindView(R.id.tab_menu_channe3)
    TextView tabMenuChanne3;
    @BindView(R.id.tab_menu_channe4)
    TextView tabMenuChanne4;
    @BindView(R.id.layout_bottom)
    LinearLayout layoutBottom;
    @BindView(R.id.content_frame)
    FrameLayout contentFrame;
    @BindView(R.id.left_drawer)
    ListView leftDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    public int getContentLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        infoViewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), HomeActivity.this));
        infoViewpager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(infoViewpager);
        //   leftDrawer.setAdapter(new SideListviewAdapter(HomeActivity.this));
        setTransparent(titleLeftTopView);
    }


    @Override
    public void initOnClick() {
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
