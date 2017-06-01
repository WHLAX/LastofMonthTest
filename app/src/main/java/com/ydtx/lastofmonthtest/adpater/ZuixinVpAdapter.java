package com.ydtx.lastofmonthtest.adpater;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.ydtx.lastofmonthtest.R;
import com.ydtx.lastofmonthtest.bean.ZuixinBean;

import java.util.List;

/**
 * 作者： 武星宇
 * 日期： 2017/6/1.
 * 类用途：
 */

public class ZuixinVpAdapter extends PagerAdapter {
    Context context;
    List<ZuixinBean.TopStoriesBean> top_stories;
    private ImageView iv;

    public ZuixinVpAdapter(Context context, List<ZuixinBean.TopStoriesBean> top_stories) {
        this.context = context;
        this.top_stories = top_stories;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.vp_item, null);
        ImageView iv = (ImageView) view.findViewById(R.id.vp_item_iv);
        ImageLoader.getInstance().displayImage(top_stories.get(position%top_stories.size()).getImage(),iv);
    container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
