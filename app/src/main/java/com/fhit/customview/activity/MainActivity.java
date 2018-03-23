package com.fhit.customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fhit.customview.R;
import com.fhit.customview.util.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.combination_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CombinationViewActivity.class));
            }
        });
        findViewById(R.id.draw_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DrawActivity.class));
            }
        });
        findViewById(R.id.draw_view_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ScDrawActivity.class));
            }
        });
        findViewById(R.id.MHorizontalScrollView_MViewPager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ViewpagerHSVActivity.class));
            }
        });
        findViewById(R.id.lottie_animation_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LottieAnimationActivity.class));
            }
        });
        test(0);
    }
    void test(int index){
        switch (index){
            default:
                LogUtils.d("default");
            case 1:
                LogUtils.d("case-1");
            case 2:
                LogUtils.d("case-2");
            case 3:
                LogUtils.d("case-3");
            case 4:
                LogUtils.d("case-4");
        }
    }
}
