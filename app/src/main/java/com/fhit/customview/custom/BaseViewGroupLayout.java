package com.fhit.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liubaoxing on 2018/3/20 09:40<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class BaseViewGroupLayout extends ViewGroup {

    public BaseViewGroupLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View v = getChildAt(0);
        measureChild(v,MeasureSpec.EXACTLY+50,MeasureSpec.EXACTLY+100);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
