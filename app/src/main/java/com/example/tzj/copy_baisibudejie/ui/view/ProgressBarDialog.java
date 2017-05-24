package com.example.tzj.copy_baisibudejie.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.tzj.copy_baisibudejie.R;

import butterknife.BindView;

/**
 * Created by tzj on 2017/5/20.
 */

public class ProgressBarDialog extends Dialog {
    @BindView(R.id.fly_icon_iv)
    ImageView flyIconIv;
    private Context context;
    private View mView;
    private AnimationDrawable mFlyDrawable;
    private boolean show1;

    public ProgressBarDialog(Context context, boolean show1) {
        super(context, R.style.WaitingDialogStyle);
        this.context = context;
        this.show1 = show1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 状态栏透明
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.progressbardialog);
        //初始化数据
        initData();
    }

    private void initData() {
        flyIconIv = (ImageView) findViewById(R.id.fly_icon_iv);
        mFlyDrawable = (AnimationDrawable) flyIconIv.getDrawable();
        showLoading(show1);

    }

    public void showLoading(boolean show) {
        if (mFlyDrawable != null) {
            if (show) {
                mFlyDrawable.start();
                show1=false;
            } else {
                mFlyDrawable.stop();
            }
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        showLoading(false);
    }
}
