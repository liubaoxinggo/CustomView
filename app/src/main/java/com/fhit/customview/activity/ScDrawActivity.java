package com.fhit.customview.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fhit.customview.R;
import com.fhit.customview.custom.DragScaleView;
import com.fhit.customview.util.LogUtils;

public class ScDrawActivity extends AppCompatActivity {

    LinearLayout rlContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_draw);
        rlContent = (LinearLayout)findViewById(R.id.content);
        init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rlContent.getChildAt(0).layout(100,80,900,680);
                //rlContent.getChildAt(0).setTranslationX();
            }
        },2000);
    }

    private void init(){
        DragScaleView dsv = new DragScaleView(this);
        rlContent.addView(dsv,800,600);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        View v = rlContent.getChildAt(0);
        int x = (int)v.getX();
        int y = (int)v.getY();
        int w = v.getWidth();
        int w1 = v.getMeasuredWidth();
        int h = v.getHeight();
        LogUtils.d("x : "+x,"y : "+y,"w : "+w,"h : "+h,"w1 : "+w1);
    }
}
