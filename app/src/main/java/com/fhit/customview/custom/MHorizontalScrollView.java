package com.fhit.customview.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import com.fhit.customview.util.LogUtils;

/**
 *横向ScrollView嵌套在viewpager内，解决横向滑动的冲突问题
 * http://blog.csdn.net/gdutxiaoxu/article/details/52939127
 * Created by liubaoxing on 2018/3/21 09:46<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class MHorizontalScrollView extends HorizontalScrollView {

    private int screenWith;
    private int childrenViewsWith;
    private void init(){
        screenWith = getResources().getDisplayMetrics().widthPixels;
    }

    public MHorizontalScrollView(Context context) {
        super(context);
        init();
    }

    public MHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        childrenViewsWith = getChildAt(0).getMeasuredWidth();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        int oX = 0;//记录按下的坐标
        switch (action){
            case MotionEvent.ACTION_DOWN:
                oX = (int)ev.getX();
                //保证子view可以接收到move事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                if((getScrollX() == 0 && ev.getX() - oX > 0) //向左滑动且已经滑动到最左边，这时将事件交给父控件处理
                        || (getScrollX() + screenWith >= childrenViewsWith && getScrollX() > 0) ){//已经滑动到最右边，这时将事件交给父控件处理
                    getParent().requestDisallowInterceptTouchEvent(false);
                }else{
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                LogUtils.d("getScrollX : "+getScrollX(),"childrenViewsWith : "+childrenViewsWith);
                break;

        }
        return super.dispatchTouchEvent(ev);
    }

}
