package com.ydtx.lastofmonthtest.frame;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ydtx.lastofmonthtest.R;
import com.ydtx.lastofmonthtest.adpater.UpDataAdapter;
import com.ydtx.lastofmonthtest.adpater.ZuixinRvAdapter;
import com.ydtx.lastofmonthtest.adpater.ZuixinVpAdapter;
import com.ydtx.lastofmonthtest.bean.UpdataBean;
import com.ydtx.lastofmonthtest.bean.ZuixinBean;
import com.ydtx.lastofmonthtest.okhttputils.NetworkUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Zuixinribao extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private View view;
    private RecyclerView rv;
    private ViewPager vp;
    private int count = 0;
    private LinearLayout vp_dian;
    /**
     * 轮播
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0) {
                int currentItem = vp.getCurrentItem();
                currentItem++;
                vp.setCurrentItem(currentItem);
                vpScollchange();
            }
        }
    };


    private SwipeRefreshLayout swipe;
    private ZuixinBean zuixinBean;
    private int conte = 1;
    private List<ZuixinBean.TopStoriesBean> top_stories;
    private List<ImageView> dianlist;
    private ImageView dianImageview;

    public Zuixinribao() {

    }

    public static Zuixinribao newInstance(String param1, String param2) {
        Zuixinribao fragment = new Zuixinribao();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_zuixinribao, container, false);
        initView();//加载控件
        requestNetworkData();//请求网络数据


        return view;
    }

    /**
     * 添加小圆点
     */
    private void addDian() {
        dianlist = new ArrayList<>(); //存放点的集合
        for (int i = 0; i < top_stories.size(); i++) {

            dianImageview = new ImageView(getActivity());

            if (i == 0) {
                dianImageview.setImageResource(R.drawable.dianset);

            } else {
                dianImageview.setImageResource(R.drawable.setdian);
            }
            dianlist.add(dianImageview);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.setMargins(5, 5, 5, 5);
            vp_dian.addView(dianImageview, params);
        }


    }

    private void requestNetworkData() {

        final String url = "http://news-at.zhihu.com/api/4/news/latest";


        new NetworkUtils().loadData(url, new Callback() {

            private String updata;
            private String net;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                net = response.body().string();

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        zuixinBean = gson.fromJson(net, ZuixinBean.class);
                        top_stories = zuixinBean.getTop_stories();
                        ZuixinVpAdapter zuixinVpAdapter = new ZuixinVpAdapter(getActivity(), top_stories);
                        vp.setAdapter(zuixinVpAdapter);

                        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
                        ZuixinRvAdapter zuixinRvAdapter = new ZuixinRvAdapter(getActivity(), top_stories);
                        rv.setAdapter(zuixinRvAdapter);

                        addDian();//添加小圆点

                        vpScollchange();//轮播
                        swipe.setColorSchemeColors(getResources().getColor(R.color.colorAccent));


                        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

                            @Override
                            public void onRefresh() {

                                conte++;
                                final String updataurl = "http://news-at.zhihu.com/api/4/news/before/2017050" + conte + "";
                                new NetworkUtils().loadData(updataurl, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        updata = response.body().string();

                                        mHandler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Gson gson = new Gson();
                                                ZuixinBean zuixinBean = gson.fromJson(updata, ZuixinBean.class);
                                                List<ZuixinBean.StoriesBean> stories = zuixinBean.getStories();


                                                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                                                rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
                                                UpDataAdapter upDataAdapter = new UpDataAdapter(getActivity(), stories);
                                                rv.setAdapter(upDataAdapter);


                                            }
                                        });
                                    }
                                });

                                swipe.setRefreshing(false);

                            }

                        });
                    }


                });
            }
        });


    }

    /**
     * 小圆点与图片的绑定，实现无限轮播
     */

    private void vpScollchange() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dianlist.size(); i++) {

                    if (i == position % dianlist.size()) {
                        dianlist.get(i).setImageResource(R.drawable.dianset);
                    } else {
                        dianlist.get(i).setImageResource(R.drawable.setdian);
                    }

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mHandler.sendEmptyMessageDelayed(0, 2000);

    }

    private void initView() {
        rv = (RecyclerView) view.findViewById(R.id.zuixin_rv);//RecyclerView

        vp = (ViewPager) view.findViewById(R.id.zuixin_vp);  //ViewPager

        vp_dian = (LinearLayout) view.findViewById(R.id.zuixin_vp_dian);  //小圆点布局

        swipe = (SwipeRefreshLayout) view.findViewById(R.id.zuixin_swipe);  //刷新布局

    }

}
