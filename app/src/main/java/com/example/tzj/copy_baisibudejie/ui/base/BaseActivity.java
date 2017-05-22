package com.example.tzj.copy_baisibudejie.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.ui.view.ProgressBarDialog;
import com.example.tzj.copy_baisibudejie.util.AllUrl;

import butterknife.ButterKnife;

/**
 * Created by tzj on 2017/5/20.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Activity activity;
    private ProgressBarDialog progressBarDialog;
    public AllUrl allUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        if (getContentLayout() != 0) {
            setContentView(getContentLayout());
        }
        ButterKnife.bind(this);
        // initView();
        initData();
        initOnClick();
        allUrl = new AllUrl();
    }

    //  public abstract void initView();

    public abstract void initData();

    public abstract void initOnClick();

    public abstract int getContentLayout();

    /**
     * 开启等待层
     */
    public void showProgressDialog() {
        if (progressBarDialog == null) {
            progressBarDialog = new ProgressBarDialog(this, true);
            progressBarDialog.setCanceledOnTouchOutside(false);
            progressBarDialog.setCancelable(true);
        }
        progressBarDialog.show();
    }

    /**
     * 隐藏等待层
     */
    public void hideProgressDialog() {
        if (progressBarDialog != null && progressBarDialog.isShowing()) {
            progressBarDialog.dismiss();
        }
    }

    /**
     * @param开启Toast
     */
    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 跳转Activity
     */
    public void openActivity(Class<?> pClass) {
        Intent intent = new Intent(this, pClass);
        startActivity(intent);
    }
    /**
     * 设置沉浸式状态栏
     */
//    protected void setStatusBar() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            final ViewGroup linear_bar = (ViewGroup) findViewById(R.id.bar_layout);
//            final int statusHeight = getStatusBarHeight();
//            linear_bar.post(new Runnable() {
//                @Override
//                public void run() {
//                    int titleHeight = linear_bar.getHeight();
//                    android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) linear_bar.getLayoutParams();
//                    params.height = statusHeight + titleHeight;
//                    linear_bar.setLayoutParams(params);
//                }
//            });
//        }
//    }
}
