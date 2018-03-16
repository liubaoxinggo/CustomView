package com.fhit.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liubaoxing on 2018/3/16 11:31<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class CounterView extends View implements View.OnClickListener,View.OnLongClickListener{

    private Paint mPaint;

    private Rect mBounds;

    private int count;

    public CounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint  = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(((ColorDrawable)getBackground()).getColor());
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

        String text = String.valueOf(count);
        mPaint.getTextBounds(text,0,text.length(),mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();

        mPaint.setColor(Color.BLUE);

        canvas.drawRect(getWidth() / 2 - textWidth * 3 / 5,getHeight() / 2 - textHeight * 3 / 4
                ,getWidth() / 2 + textWidth ,getHeight() / 2 + textHeight * 3 / 4,mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setTextSize(230);
        canvas.drawText(text,getWidth() / 2 - textWidth / 2,getHeight() / 2 + textHeight / 2,mPaint);
    }

    @Override
    public void onClick(View v) {
        count++;
        invalidate();
    }

    @Override
    public boolean onLongClick(View v) {
        count = 0;
        invalidate();
        return true;
    }

}

