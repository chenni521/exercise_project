package com.example.tzj.copy_baisibudejie.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tzj.copy_baisibudejie.ui.fragment.BlankFragment;
import com.example.tzj.copy_baisibudejie.ui.fragment.PageFragment;

/**
 * Created by tzj on 2017/5/22.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] titles = {"推荐", "视频", "图片", "段子", "排行", "互动区", "网红", "社会", "投票", "美女", "冷知识", "游戏"};//头部标签
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return PageFragment.newInstance(position + 1);
        } else if (position == 1) {
            return BlankFragment.newInstance(position + 1);
        }
        return BlankFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
