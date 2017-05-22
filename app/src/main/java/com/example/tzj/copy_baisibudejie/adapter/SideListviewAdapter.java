package com.example.tzj.copy_baisibudejie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tzj.copy_baisibudejie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tzj on 2017/5/22.
 */

public class SideListviewAdapter extends BaseAdapter {
    private String item[] = {"精华", "新帖", "败家姐", "我的"};
    private Context context;

    public SideListviewAdapter(Context context) {
        this.context = context;
    }

    @Override

    public int getCount() {
        return item.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.listItemTextview.setText(item[position]);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.list_item_image)
        ImageView listItemImage;
        @BindView(R.id.list_item_textview)
        TextView listItemTextview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
