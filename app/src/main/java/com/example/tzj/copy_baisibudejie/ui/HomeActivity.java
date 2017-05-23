package com.example.tzj.copy_baisibudejie.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.adapter.MyFragmentPagerAdapter;
import com.example.tzj.copy_baisibudejie.adapter.SideListviewAdapter;
import com.example.tzj.copy_baisibudejie.entity.Bean1;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;
import com.example.tzj.copy_baisibudejie.util.LogUtil;
import com.example.tzj.copy_baisibudejie.util.RequestServes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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


    @Override
    public void initData() {
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        infoViewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), HomeActivity.this));
        tabLayout.setupWithViewPager(infoViewpager);
        leftDrawer.setAdapter(new SideListviewAdapter(HomeActivity.this));

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
