package com.example.tzj.copy_baisibudejie.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.tzj.copy_baisibudejie.R;
import com.example.tzj.copy_baisibudejie.adapter.RecommendAdapter;
import com.example.tzj.copy_baisibudejie.entity.Bean1;
import com.example.tzj.copy_baisibudejie.entity.RecommendVo;
import com.example.tzj.copy_baisibudejie.ui.activity.ImageActivity;
import com.example.tzj.copy_baisibudejie.ui.activity.VideoActivity;
import com.example.tzj.copy_baisibudejie.ui.base.BaseActivity;
import com.example.tzj.copy_baisibudejie.ui.base.LazyFragment;
import com.example.tzj.copy_baisibudejie.util.AllUrl;
import com.example.tzj.copy_baisibudejie.util.LogUtil;
import com.example.tzj.copy_baisibudejie.util.MyUtil;
import com.example.tzj.copy_baisibudejie.util.RequestServes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends LazyFragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    public static final String ARGS_PAGE = "args_page";
    @BindView(R.id.fragment_page_image)
    ImageView fragmentPageImage;
    @BindView(R.id.fragment_page_listview)
    RecyclerView fragmentPageListview;
    @BindView(R.id.bga)
    BGARefreshLayout bga;
    private int mPage;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    private int page = 1;
    private int removeList = 0;

    private Bean1 bean1 = new Bean1();
    private RecommendVo recommendVo = new RecommendVo();
    private BaseActivity baseActivity;
    private List<RecommendVo.ListBean> list = new ArrayList<RecommendVo.ListBean>();
    private List<RecommendVo.ListBean> AllList = new ArrayList<RecommendVo.ListBean>();
    private RecommendAdapter recommendAdapter;
    private List<RecommendVo.ListBean> finalList = new ArrayList<RecommendVo.ListBean>();

   /* @BindView(R.id.textView)
    TextView textView;*/

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();

        args.putInt(ARGS_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        baseActivity = (BaseActivity) getActivity();
        initRefreshLayout();
        getRetrofit();
        getRecommendInterface(0, 5);
        //填充各控件的数据
        recommendAdapter = new RecommendAdapter(finalList, getActivity(),getActivity());
        fragmentPageListview.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentPageListview.setAdapter(recommendAdapter);
    }

    private void initRefreshLayout() {
        bga.setDelegate(this);
        BGAMoocStyleRefreshViewHolder refreshViewHolder = new BGAMoocStyleRefreshViewHolder(getActivity(), true);
        refreshViewHolder.setOriginalImage(R.mipmap.bga_refresh_mt_refreshing_01);
        refreshViewHolder.setUltimateColor(R.color.imoocstyle);
        bga.setRefreshViewHolder(refreshViewHolder);

    }

    /**
     * 网络请求的配置
     */
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AllUrl.HOME_TITLE_IMAGE)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    RequestServes requestServes = retrofit.create(RequestServes.class);


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
//        textView.setText("第" + mPage + "页");
        isPrepared = true;
        lazyLoad();
        return view;
    }

    private void getRetrofit() {
        Call<Bean1> call = requestServes.headerHttpPost("tencentyingyongbao",
                "864394010288340",
                "baisibudejie",
                "4.4.2",
                "android",
                "",
                "1C%3A83%3A41%3A13%3A80%3A8E",
                "6.7.2");

        call.enqueue(new Callback<Bean1>() {
            @Override
            public void onResponse(Call<Bean1> call, Response<Bean1> response) {
//                LogUtil.e(response.body().toString());
                Bean1 bean1 = response.body();
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

    private void getRecommendInterface(final long firstPositon, final int lastPosition) {
        baseActivity.showProgressDialog(true);
        Call<RecommendVo> call = requestServes.recommendHttpPost(firstPositon, lastPosition, "tencentyingyongbao",
                "864394010288340",
                "baisibudejie",
                "4.4.2",
                "android",
                "",
                "1C%3A83%3A41%3A13%3A80%3A8E",
                "6.7.2");

        call.enqueue(new Callback<RecommendVo>() {
            @Override
            public void onResponse(Call<RecommendVo> call, Response<RecommendVo> response) {
//                LogUtil.e(response.body().toString());
                RecommendVo bean1 = response.body();
                list.clear();
                list = bean1.getList();
                finalList.addAll(list);
                recommendAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        if (view.getId() == R.id.content_video) {
                            Intent intent = new Intent(getActivity(), VideoActivity.class);
                            intent.putExtra("url", finalList.get(position).getVideo().getVideo().get(0));
                            intent.putExtra("content", finalList.get(position).getText());
                            getActivity().startActivity(intent);
                        } else if (view.getId() == R.id.content_gif) {
                            Intent intent = new Intent(getActivity(), ImageActivity.class);
                            intent.putExtra("url", finalList.get(position).getImage().getBig().get(0));
                            getActivity().startActivity(intent);
                        }
                    }
                });
                baseActivity.hideProgressDialog();
      //          recommendAdapter.addData(finalList);
                recommendAdapter.notifyDataSetChanged();
                bga.endRefreshing();
                bga.endLoadingMore();
            }

            @Override
            public void onFailure(Call<RecommendVo> call, Throwable t) {
                LogUtil.e(t.getMessage().toString());
            }
        });
    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        getRecommendInterface(0, 5);
        finalList.clear();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        try {
            LogUtil.e(list.get(list.size()-1).getPasstime());

            long lastTime= Long.parseLong(MyUtil.dateToStamp(list.get(list.size()-1).getPasstime().trim()));
            getRecommendInterface(lastTime, 5);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        page++;
        return false;
    }

    // 通过代码方式控制进入正在刷新状态。应用场景：某些应用在 activity 的 onStart 方法中调用，自动进入正在刷新状态获取最新数据
    public void beginRefreshing() {
        bga.beginRefreshing();
    }

    // 通过代码方式控制进入加载更多状态
    public void beginLoadingMore() {
        bga.beginLoadingMore();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
