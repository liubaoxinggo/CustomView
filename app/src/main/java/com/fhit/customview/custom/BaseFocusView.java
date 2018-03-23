package com.fhit.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * http://www.cnblogs.com/tangs/articles/5864092.html
 * 绘制边界框
 * Created by liubaoxing on 2018/3/15 16:32<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class BaseFocusView extends View {

    private Paint paint;//边界画笔
    private Paint mPaint;//边界方块画笔
    private int width;
    private int height;
    /**
     * 边界范围，周边小方块的大小
     */
    private int boundarySize;
    private int strokeWidth = 4;

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);

        mPaint = new Paint(paint);
        mPaint.setStyle(Paint.Style.FILL);

        boundarySize = 40;


    }

    public BaseFocusView(Context context) {
        super(context);
        init();
    }

    public BaseFocusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 设置边界范围大小
     * @param boundarySize
     */
    public void setBoundarySize(int boundarySize) {
        this.boundarySize = boundarySize;
    }

    /**
     * 设置边界线宽度
     * @param strokeWidth
     */
    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        width = getWidth();//不能在这里这样设置，这里是固定大小
//        height = getHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = right - left;//这里设置，可以随view的缩放进行变化
        height = bottom - top;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //边界线
        drawRect(canvas,paint,boundarySize / 2,boundarySize / 2, width - boundarySize / 2, height - boundarySize / 2);
        //左上角
        drawRect(canvas,mPaint,0,0, boundarySize, boundarySize);
        //上边中间
        drawRect(canvas,mPaint,(width - boundarySize) / 2,0,(width + boundarySize) / 2, boundarySize);
        //右上角
        drawRect(canvas,mPaint,width - boundarySize,0, width , boundarySize);
        //右边中间
        drawRect(canvas,mPaint,width - boundarySize,(height - boundarySize) / 2, width ,(height + boundarySize) / 2);
        //右下角
        drawRect(canvas,mPaint,width - boundarySize,height - boundarySize, width ,height);
        //下边中间
        drawRect(canvas,mPaint,(width - boundarySize) / 2 ,height - boundarySize, (width + boundarySize) / 2 ,height);
        //左下角
        drawRect(canvas,mPaint,0 ,height - boundarySize, boundarySize,height);
        //左边中间
        drawRect(canvas,mPaint,0 ,(height - boundarySize) / 2, boundarySize,(height + boundarySize) / 2);

    }

    private void drawRect(Canvas canvas,Paint mPaint,int left, int top, int right, int bottom){
        RectF rectF = new RectF(left,top,right,bottom);
        canvas.drawRect(rectF,mPaint);
    }
}
