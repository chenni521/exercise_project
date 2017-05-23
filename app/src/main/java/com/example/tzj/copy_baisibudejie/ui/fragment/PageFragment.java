package com.example.tzj.copy_baisibudejie.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.entity.Bean1;
import com.example.tzj.copy_baisibudejie.util.AllUrl;
import com.example.tzj.copy_baisibudejie.util.LogUtil;
import com.example.tzj.copy_baisibudejie.util.RequestServes;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    @BindView(R.id.fragment_page_image)
    ImageView fragmentPageImage;
    @BindView(R.id.fragment_page_listview)
    ListView fragmentPageListview;
    private int mPage;

    @BindView(R.id.textView)
    TextView textView;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();

        args.putInt(ARGS_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ButterKnife.bind(this, view);
        textView.setText("第" + mPage + "页");
        getRetrofit();
        return view;
    }

    private void getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AllUrl.HOME_TITLE_IMAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestServes requestServes = retrofit.create(RequestServes.class);
        Call<Bean1> call = requestServes.testHttpGet();
//        Call<String> call = requestServes.testHttpPost("tencentyingyongbao",
//                "864394010288340",
//                "baisibudejie",
//                "4.4.2",
//                "android",
//                "",
//                "1C%3A83%3A41%3A13%3A80%3A8E",
//                "6.7.2");
        call.enqueue(new Callback<Bean1>() {
            @Override
            public void onResponse(Call<Bean1> call, Response<Bean1> response) {
                LogUtil.e(response.body().toString());
                Bean1 bean1 = new Bean1();
                bean1 = response.body();
                String url = bean1.getResult().getJingxuan().get_$1().get(0).getImage();
                Glide.with(getActivity())
                        .load(url)
                        .into(fragmentPageImage);

            }

            @Override
            public void onFailure(Call<Bean1> call, Throwable t) {
                LogUtil.e(t.getMessage().toString());
            }
        });

    }
}
