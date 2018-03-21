package com.fhit.customview.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fhit.customview.MPagerAdapter;
import com.fhit.customview.R;
import com.fhit.customview.custom.MHorizontalScrollView;
import com.fhit.customview.util.LogUtils;

import java.util.ArrayList;

public class ViewpagerHSVActivity extends AppCompatActivity {
    ViewPager mViewPager;
    MHorizontalScrollView mHorizontalScrollView;
    TextView tvInfo;
    MPagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_hsv);
        mViewPager = (ViewPager)findViewById(R.id.m_view_pager);
        mHorizontalScrollView = (MHorizontalScrollView)findViewById(R.id.m_horizontal_scroll_view);
        tvInfo = (TextView)findViewById(R.id.tv_info);
        init();
    }
    private void init(){
        ArrayList<View> views = new ArrayList<>();
        views.add(LayoutInflater.from(this).inflate(R.layout.viewpager_hsv_item_1,null));
        views.add(LayoutInflater.from(this).inflate(R.layout.viewpager_hsv_item_2,null));
        mPagerAdapter = new MPagerAdapter(views);
        mViewPager.setAdapter(mPagerAdapter);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LogUtils.d("getWidth : "+tvInfo.getWidth(),"getMeasuredWidth : "+tvInfo.getMeasuredWidth());
    }
}
