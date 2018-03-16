package com.fhit.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.fhit.customview.util.LogUtils;

/**
 * Created by liubaoxing on 2018/3/15 17:37<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class MyFrameLayout extends FrameLayout {
    public MyFrameLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtils.d("MyLinearLayout---onMeasure","widthMeasureSpec : "+widthMeasureSpec,"heightMeasureSpec : "+heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int width = this.getWidth();
        int height = this.getHeight();
        LogUtils.d("MyLinearLayout---onLayout","changed :"+changed,"left :"+left,"top :"+top
                ,"right :"+right,"bottom :"+bottom,"width :"+width,"height :"+height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("MyLinearLayout---onDraw");
    }

}
