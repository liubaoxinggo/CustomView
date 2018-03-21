package com.fhit.customview;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
/**
 * http://blog.csdn.net/a872822645/article/details/61925194
 * Created by liubaoxing on 2018/3/21 10:41<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class MPagerAdapter extends PagerAdapter {
    private List<View> mViewList;

    public MPagerAdapter(List<View> mViewList) {
        this.mViewList = mViewList;
    }

    @Override
    public int getCount() {
        return mViewList == null ? 0 : mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView(mViewList.get(position));
    }
}
