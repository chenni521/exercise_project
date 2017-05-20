package com.example.tzj.copy_baisibudejie.ui.basa;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import butterknife.OnClick;

/**
 * Created by tzj on 2017/5/20.
 */

public abstract class BasaActivity extends AppCompatActivity {
    protected Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initOnClick();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract void initOnClick();


}
