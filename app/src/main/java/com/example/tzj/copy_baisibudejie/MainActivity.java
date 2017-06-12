package com.example.tzj.copy_baisibudejie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.tzj.copy_baisibudejie.ui.activity.HomeActivity;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;
import com.example.tzj.copy_baisibudejie.ui.view.CustomVideoView;
import com.example.tzj.copy_baisibudejie.util.ExampleUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends BaseActivity {

    @BindView(R.id.welcome_videoview)
    CustomVideoView welcomeVideoview;
    @BindView(R.id.welcome_button)
    Button welcomeButton;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    public static boolean isForeground = false;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.tzj.copy_baisibudejie.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    private MessageReceiver mMessageReceiver;
    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        welcomeVideoview.setVideoURI(Uri.parse("android.resource://"+this.getPackageName()+"/"+R.raw.start));
        welcomeVideoview.start();
        JPushInterface.init(getApplicationContext());
        registerMessageReceiver();
    }

    @Override
    public void initOnClick() {
        welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        welcomeVideoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                welcomeVideoview.start();
            }
        });
    }
    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }
    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(KEY_MESSAGE);
                    String extras = intent.getStringExtra(KEY_EXTRAS);
                    StringBuilder showMsg = new StringBuilder();
                    showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                    if (!ExampleUtil.isEmpty(extras)) {
                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                    }
                    setCostomMsg(showMsg.toString());
                }
            } catch (Exception e){
            }
        }
    }

    private void setCostomMsg(String msg){
//        if (null != msgText) {
//            msgText.setText(msg);
//            msgText.setVisibility(android.view.View.VISIBLE);
//        }
    }
}
