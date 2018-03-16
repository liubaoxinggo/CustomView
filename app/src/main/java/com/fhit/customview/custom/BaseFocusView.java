package com.fhit.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.fhit.customview.util.LogUtils;

/**
 * Created by liubaoxing on 2018/3/15 16:32<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class BaseFocusView extends View {

    Paint paint;
    int width;
    int height;
    int size;
    public BaseFocusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        size = 40;
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rect = new RectF(size / 2,size / 2,width - size / 2, height - size / 2);
//        Path path = new Path();
//        path.addRect(rect, Path.Direction.CW);//顺时针方向绘制
//        canvas.drawPath(path,paint);
        canvas.drawRect(rect,paint);

        //需要设置新的画笔
        Paint mPaint = new Paint(paint);
        mPaint.setStyle(Paint.Style.FILL);

        //左上角
        drawRect(canvas,mPaint,0,0,size,size);
        //上边中间
        drawRect(canvas,mPaint,(width - size) / 2,0,(width + size) / 2,size);
        //右上角
        drawRect(canvas,mPaint,width - size ,0, width ,size);
        //右边中间
        drawRect(canvas,mPaint,width - size ,(height - size) / 2, width ,(height + size) / 2);
        //右下角
        drawRect(canvas,mPaint,width - size ,height - size, width ,height);
        //下边中间
        drawRect(canvas,mPaint,(width - size) / 2 ,height - size, (width + size) / 2 ,height);
        //左下角
        drawRect(canvas,mPaint,0 ,height - size, size ,height);
        //左边中间
        drawRect(canvas,mPaint,0 ,(height - size) / 2, size ,(height + size) / 2);



    }

    private void drawRect(Canvas canvas,Paint mPaint,int left, int top, int right, int bottom){
        RectF rectF = new RectF(left,top,right,bottom);
        canvas.drawRect(rectF,mPaint);
    }
}
