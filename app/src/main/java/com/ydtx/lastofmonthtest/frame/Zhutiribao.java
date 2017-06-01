package com.ydtx.lastofmonthtest.frame;


import android.os.Bundle;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.google.gson.Gson;
import com.ydtx.lastofmonthtest.R;
import com.ydtx.lastofmonthtest.adpater.ZhutiRvAdapter;
import com.ydtx.lastofmonthtest.bean.ZhutiBean;
import com.ydtx.lastofmonthtest.okhttputils.NetworkUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class Zhutiribao extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private RecyclerView rv;
    private View view;
    private Handler mhandler = new Handler() {
    };


    public Zhutiribao() {

    }


    public static Zhutiribao newInstance(String param1, String param2) {
        Zhutiribao fragment = new Zhutiribao();
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
        view = inflater.inflate(R.layout.fragment_zhutiribao, container, false);
        initView();//加载控件
        addData();//添加数据

        return view;
    }

    private void addData() {
        String url = "http://news-at.zhihu.com/api/4/themes";
        new NetworkUtils().loadData(url, new Callback() {

            private String net;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                net = response.body().string();

                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        ZhutiBean zhutiBean = gson.fromJson(net, ZhutiBean.class);
                        List<ZhutiBean.OthersBean> others = zhutiBean.getOthers();

                        ZhutiRvAdapter zhutiRvAdapter = new ZhutiRvAdapter(getActivity(), others);

                        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//                        rv.addItemDecoration(new DividerItemDecoration(getActivity(), GridLayout.VERTICAL));
                        rv.setAdapter(zhutiRvAdapter);
                    }
                });


            }
        });


    }

    private void initView() {

        rv = (RecyclerView) view.findViewById(R.id.zhuti_rv);
    }

}
