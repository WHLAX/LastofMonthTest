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
import com.ydtx.lastofmonthtest.bean.ZuixinBean;

import java.util.List;

/**
 * 作者： 武星宇
 * 日期： 2017/6/1.
 * 类用途：
 */

public class UpDataAdapter extends RecyclerView.Adapter<UpDataAdapter.MMyAdapter> {

    Context context;
    List<ZuixinBean.StoriesBean> stories;
    public UpDataAdapter(Context context, List<ZuixinBean.StoriesBean> stories){
        this.context = context;
        this.stories = stories;
    }
    @Override
    public MMyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, null);

        return new MMyAdapter(view);
    }

    @Override
    public void onBindViewHolder(MMyAdapter holder, int position) {


        ImageLoader.getInstance().displayImage(stories.get(position).getImages().get(0),holder.iv);
        holder.title.setText(stories.get(position).getTitle());
        holder.cont.setText(stories.get(position).getGa_prefix());

    }


    @Override
    public int getItemCount() {
        return stories.size();
    }

    class MMyAdapter extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView title;
        private final TextView cont;

        public MMyAdapter(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.rv_item_iv);
            title = (TextView) itemView.findViewById(R.id.rv_item_title);
            cont = (TextView) itemView.findViewById(R.id.rv_item_cont);

        }
    }
}
