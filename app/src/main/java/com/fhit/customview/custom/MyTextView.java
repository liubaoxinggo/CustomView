package com.fhit.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.fhit.customview.util.LogUtils;

/**
 * Created by liubaoxing on 2018/3/15 16:42<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtils.d("MyTextView---onMeasure","widthMeasureSpec : "+widthMeasureSpec,"heightMeasureSpec : "+heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int width = this.getWidth();
        int height = this.getHeight();
        LogUtils.d("MyTextView---onLayout","changed :"+changed,"left :"+left,"top :"+top
                ,"right :"+right,"bottom :"+bottom,"width :"+width,"height :"+height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("MyTextView---onDraw");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
