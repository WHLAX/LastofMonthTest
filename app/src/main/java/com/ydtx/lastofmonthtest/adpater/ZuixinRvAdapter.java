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
import com.ydtx.lastofmonthtest.bean.UpdataBean;
import com.ydtx.lastofmonthtest.bean.ZuixinBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 武星宇
 * 日期： 2017/6/1.
 * 类用途：
 */

public class ZuixinRvAdapter extends RecyclerView.Adapter<ZuixinRvAdapter.MyAdapter> {
    Context context;
    List<ZuixinBean.TopStoriesBean> top_stories;
    public ZuixinRvAdapter(Context context, List<ZuixinBean.TopStoriesBean> top_stories){
        this.context = context;
        this.top_stories = top_stories;
    }
    @Override
    public MyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, null);



        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter holder, int position) {

        ImageLoader.getInstance().displayImage(top_stories.get(position).getImage(),holder.iv);
        holder.title.setText(top_stories.get(position).getTitle());
        holder.cont.setText(top_stories.get(position).getGa_prefix());

    }


    @Override
    public int getItemCount() {
        return top_stories.size();
    }



    class MyAdapter extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView title;
        private final TextView cont;

        public MyAdapter(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.rv_item_iv);
            title = (TextView) itemView.findViewById(R.id.rv_item_title);
            cont = (TextView) itemView.findViewById(R.id.rv_item_cont);

        }
    }
}
