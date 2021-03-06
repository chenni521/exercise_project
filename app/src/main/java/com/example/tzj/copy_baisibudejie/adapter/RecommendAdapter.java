package com.example.tzj.copy_baisibudejie.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.entity.RecommendVo;
import com.example.tzj.copy_baisibudejie.util.LogUtil;

import org.lynxz.zzplayerlibrary.widget.VideoPlayer;

import java.util.List;

/**
 * Created by psj on 2017/5/23.
 */

public class RecommendAdapter extends BaseMultiItemQuickAdapter<RecommendVo.ListBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private Context context;
    private Activity activity;
    public RecommendAdapter(List<RecommendVo.ListBean> data, Context context,Activity activity) {
        super(data);
        addItemType(RecommendVo.ListBean.GIF, R.layout.gif_listview_item);
        addItemType(RecommendVo.ListBean.IMAGE, R.layout.gif_listview_item);
        addItemType(RecommendVo.ListBean.TEXT, R.layout.text_listview_item);
        addItemType(RecommendVo.ListBean.VIDEO, R.layout.video_listview_item);
        this.context = context;
        this.activity=activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendVo.ListBean item) {
//        LogUtil.e(helper.getItemViewType() + "");
        switch (helper.getItemViewType()) {
            case RecommendVo.ListBean.GIF:
                ImageView imageView = helper.getView(R.id.content_gif);
                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height=item.getGif().getWidth();
                params.width =item.getGif().getHeight();
                imageView.setLayoutParams(params);
                Glide.with(context)
                        .load(item.getGif().getImages().get(0))
                        .into(imageView);

                Glide.with(context)
                        .load(item.getU().getHeader().get(0))
                        .into((ImageView) helper.getView(R.id.user_img));
                helper.setText(R.id.user_name, item.getU().getName());
                helper.setText(R.id.user_date, item.getPasstime());
                helper.setText(R.id.content_text,item.getText());
                break;

            case RecommendVo.ListBean.IMAGE:
                ImageView imageView2 = helper.getView(R.id.content_gif);
//                imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                imageView2.setAdjustViewBounds(true);
                ViewGroup.LayoutParams params1 = imageView2.getLayoutParams();
                params1.height=item.getImage().getWidth();
                params1.width =item.getImage().getHeight();
                imageView2.setLayoutParams(params1);
                Glide.with(context)
                        .load(item.getImage().getBig().get(0))
                        .into(imageView2);

                Glide.with(context)
                        .load(item.getU().getHeader().get(0))
                        .into((ImageView) helper.getView(R.id.user_img));

                LogUtil.e(imageView2.getHeight()+"-------");
                LogUtil.e(imageView2.getWidth()+"-------");
                helper.setText(R.id.user_name, item.getU().getName());
                helper.setText(R.id.user_date, item.getPasstime());
                helper.setText(R.id.content_text,item.getText());
                helper.addOnClickListener(R.id.content_gif);
                break;

            case RecommendVo.ListBean.TEXT:
                helper.setText(R.id.content_text, item.getText());

                Glide.with(context)
                        .load(item.getU().getHeader().get(0))
                        .into((ImageView) helper.getView(R.id.user_img));
                helper.setText(R.id.user_name, item.getU().getName());
                helper.setText(R.id.user_date, item.getPasstime());
                break;

            case RecommendVo.ListBean.VIDEO:
                Glide.with(context)
                        .load(item.getVideo().getThumbnail().get(0))
                        .into((ImageView) helper.getView(R.id.content_video));

                helper.setText(R.id.content_text, item.getText());

                Glide.with(context)
                        .load(item.getU().getHeader().get(0))
                        .into((ImageView) helper.getView(R.id.user_img));
                helper.setText(R.id.user_name, item.getU().getName());
                helper.setText(R.id.user_date, item.getPasstime());

                helper.addOnClickListener(R.id.content_video);
                break;
        }
    }
}
