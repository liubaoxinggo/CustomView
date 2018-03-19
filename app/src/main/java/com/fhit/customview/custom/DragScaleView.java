package com.fhit.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View;

/**
 * 可缩放拖拽的view
 * http://blog.csdn.net/weixin_31767183/article/details/78929993
 * Created by liubaoxing on 2018/3/19 11:04<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */
//如果换成继承View 下面的边界框就要画上
public class DragScaleView extends BaseFocusView implements View.OnTouchListener {

    private int screenWith;
    private int screenHeigh;
    private int lastX;
    private int lastY;
    private int oriLeft;
    private int oriRight;
    private int oriTop;
    private int oriBottom;
    private int dragDirection;

    private static final int TOP = 0x15;
    private static final int LEFT = 0x16;
    private static final int BOTTOM = 0x17;
    private static final int RIGHT = 0x18;
    private static final int LEFT_TOP = 0x11;
    private static final int RIGHT_TOP = 0x12;
    private static final int LEFT_BOTTOM = 0x13;
    private static final int RIGHT_BOTTOM = 0x14;
    private static final int CENTER = 0x19;
    private int offset = 20;
    private int boundary = 40;
    protected Paint paint = new Paint();

    private void initScreenW_H(){
        screenWith = getResources().getDisplayMetrics().widthPixels;
        screenHeigh = getResources().getDisplayMetrics().heightPixels - 40;
    }

    public DragScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setClickable(true);//必须设置为true，否则无效
        setOnTouchListener(this);
        initScreenW_H();
        setBoundarySize(boundary);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4.0f);
        paint.setStyle(Paint.Style.STROKE);
        //继承了 BaseFocusView ，就不需要绘制边界线了
        //canvas.drawRect(offset,offset,getWidth() - offset,getHeight() - offset,paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action  = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            oriLeft = v.getLeft();
            oriBottom = v.getBottom();
            oriRight = v.getRight();
            oriTop = v.getTop();
            lastX = (int)event.getRawX();
            lastY = (int)event.getRawY();
            dragDirection = getDirection(v,(int)event.getX(),(int)event.getY());
        }
        delDrag(v,event,action);
        invalidate();
        return false;
    }
    private int getDirection(View v,int x,int y){
        int left = v.getLeft();
        int right = v.getRight();
        int bottom = v.getBottom();
        int top = v.getTop();
        if(x < boundary && y < boundary){
            return LEFT_TOP;
        }
        if(y < boundary && right - left - x < boundary){
            return RIGHT_TOP;
        }
        if(x < boundary && bottom - top - y < boundary){
            return LEFT_BOTTOM;
        }
        if(right - left - x < boundary && bottom - top - y < boundary){
            return RIGHT_BOTTOM;
        }
        if(x < boundary){
            return LEFT;
        }
        if(y < boundary){
            return TOP;
        }
        if(right - left - x < boundary ){
            return RIGHT;
        }
        if(bottom - top - y < boundary){
            return BOTTOM;
        }
        return CENTER;
    }
    private void delDrag(View v,MotionEvent event,int action){
        switch (action){
            case MotionEvent.ACTION_MOVE:
                int dx = (int)event.getRawX() - lastX;
                int dy = (int)event.getRawY() - lastY;
                switch (dragDirection){
                    case LEFT:
                        left(v,dx);
                        break;
                    case RIGHT:
                        right(v,dx);
                        break;
                    case TOP:
                        top(v,dy);
                        break;
                    case BOTTOM:
                        bottom(v,dy);
                        break;
                    case CENTER:
                        center(v,dx,dy);
                        break;
                    case LEFT_TOP:
                        left(v,dx);
                        top(v,dy);
                        break;
                    case LEFT_BOTTOM:
                        left(v,dx);
                        bottom(v,dy);
                        break;
                    case RIGHT_TOP:
                        right(v,dx);
                        top(v,dy);
                        break;
                    case RIGHT_BOTTOM:
                        right(v,dx);
                        bottom(v,dy);
                        break;
                }
                v.layout(oriLeft,oriTop,oriRight,oriBottom);
                if(dragDirection != CENTER){
                }
                lastX = (int)event.getRawX();
                lastY = (int)event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                dragDirection = 0;
                break;
        }
    }
    /**
     * 左边界拉伸
     */
    private void left(View v,int dx){
        oriLeft += dx;
    }
    /**
     * 右边界拉伸
     */
    private void right(View v,int dx){
        oriRight += dx;
    }
    /**
     * 上边界拉伸
     */
    private void top(View v,int dy){
        oriTop += dy;
    }
    /**
     * 下边界拉伸
     */
    private void bottom(View v,int dy){
        oriBottom += dy;
    }

    /**
     * 移动
     */
    private void center(View v,int dx ,int dy){
        oriLeft += dx;
        oriRight += dx;
        oriTop += dy;
        oriBottom += dy;

    }
}
