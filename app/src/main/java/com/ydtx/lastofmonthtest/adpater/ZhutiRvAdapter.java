package com.ydtx.lastofmonthtest.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.ydtx.lastofmonthtest.R;
import com.ydtx.lastofmonthtest.bean.ZhutiBean;

import java.util.List;

/**
 * 作者： 武星宇
 * 日期： 2017/6/1.
 * 类用途：
 */

public class ZhutiRvAdapter extends RecyclerView.Adapter<ZhutiRvAdapter.MmyAdapter> {

    Context context;
    List<ZhutiBean.OthersBean> others;
    public ZhutiRvAdapter(Context context, List<ZhutiBean.OthersBean> others){
        this.context = context;
        this.others = others;
    }

    @Override
    public MmyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.zhuti_item_rv, null);

        return new MmyAdapter(view);
    }

    @Override
    public void onBindViewHolder(MmyAdapter holder, int position) {

        ImageLoader.getInstance().displayImage(others.get(position).getThumbnail(),holder.iv);
        holder.tv.setText(others.get(position).getName());


    }



    @Override
    public int getItemCount() {
        return others.size();
    }

    class MmyAdapter extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv;

        public MmyAdapter(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.zhuti_item_iv);
            tv = (TextView) itemView.findViewById(R.id.zhuti_item_tv);

        }
    }

}
