package com.example.tzj.copy_baisibudejie.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.ui.base.LazyFragment;
import com.example.tzj.copy_baisibudejie.util.LogUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends LazyFragment {


    public BlankFragment() {
        // Required empty public constructor
    }
    public static BlankFragment newInstance(int page) {
      //  Bundle args = new Bundle();

        BlankFragment fragment = new BlankFragment();
      //  fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LogUtil.e("BlankFragment==============onCreateView");
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    protected void lazyLoad() {

    }
}
