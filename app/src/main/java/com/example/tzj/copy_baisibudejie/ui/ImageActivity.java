package com.example.tzj.copy_baisibudejie.ui;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Environment;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;
import com.example.tzj.copy_baisibudejie.util.LogUtil;
import com.example.tzj.copy_baisibudejie.util.PermissionsChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;

/**
 * Created by psj on 2017/5/24.
 */

public class ImageActivity extends BaseActivity {

    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @BindView(R.id.title_left_topView)
    View titleLeftTopView;
    @BindView(R.id.imageView)
    SubsamplingScaleImageView progressImageview;

    String url = "";

    private PermissionsChecker mPermissionsChecker; // 权限检测器
    private static final int REQUEST_CODE = 0; // 请求码


    @Override
    public int getContentLayout() {
        return R.layout.image_layout;
    }

    @Override
    public void initData() {
        mPermissionsChecker = new PermissionsChecker(this);
        setTransparent(titleLeftTopView);
        Intent intent = getIntent();
        if (intent != null) {
            url = intent.getStringExtra("url");
        }

        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            startPermissionsActivity();
        }

        addPic(progressImageview, url);

    }

    private void addPic(final SubsamplingScaleImageView imageView, final String url) {
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
        imageView.setMinScale(1.0F);
        final String downPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/glide/";
        //使用Glide下载图片,保存到本地
        Glide.with(this)
                .load(url)
                .asBitmap()
                .placeholder(R.mipmap.loading)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        String[] urlArray = url.split("/");
                        LogUtil.e(url);
                        LogUtil.e(urlArray[urlArray.length - 1]);
                        File file = new File(downPath + urlArray[urlArray.length - 1]);
                        if (!file.exists()) {
                            try {
                                file.getParentFile().mkdirs();
                                file.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                                LogUtil.e(e.getMessage());
                            }
                        }
                        FileOutputStream fout = null;
                        try {
                            //保存图片
                            fout = new FileOutputStream(file);
                            resource.compress(Bitmap.CompressFormat.JPEG, 100, fout);
                            // 将保存的地址给SubsamplingScaleImageView,这里注意设置ImageViewState
                            imageView.setImage(ImageSource.uri(file.getAbsolutePath()), new ImageViewState(2.0F, new PointF(0, 0), 0));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (fout != null) fout.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    @Override
    public void initOnClick() {

    }

    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
