package com.example.tzj.copy_baisibudejie.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.adapter.MyFragmentPagerAdapter;
import com.example.tzj.copy_baisibudejie.adapter.SideListviewAdapter;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;
import com.example.tzj.copy_baisibudejie.util.LogUtil;
import com.example.tzj.copy_baisibudejie.util.RequestServes;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        getRetrofit();
    }

    private void getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(allUrl.HOME_TITLE_IMAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestServes requestServes = retrofit.create(RequestServes.class);
        Call<RequestServes.ResponseInfo> call = requestServes.testHttpGet();
//        Call<String> call = requestServes.testHttpPost("tencentyingyongbao",
//                "864394010288340",
//                "baisibudejie",
//                "4.4.2",
//                "android",
//                "",
//                "1C%3A83%3A41%3A13%3A80%3A8E",
//                "6.7.2");
        call.enqueue(new Callback<RequestServes.ResponseInfo>() {
            @Override
            public void onResponse(Call<RequestServes.ResponseInfo> call, Response<RequestServes.ResponseInfo> response) {
            }

            @Override
            public void onFailure(Call<RequestServes.ResponseInfo> call, Throwable t) {
                LogUtil.e(t.getMessage().toString());
            }
        });

    }

    @Override
    public void initOnClick() {
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_home;
    }


}
