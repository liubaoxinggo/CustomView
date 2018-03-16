package com.fhit.customview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fhit.customview.R;
import com.fhit.customview.custom.TitleView;
import com.fhit.customview.util.LogUtils;

public class CombinationViewActivity extends AppCompatActivity {

    TitleView mTitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination_view);
        mTitleView = (TitleView)findViewById(R.id.title);
        mTitleView.setTitle("自定义组合控件");
        mTitleView.setLeftBtnText("返回");
        mTitleView.setLeftBtnOnClickListener(new TitleView.MOnClickListener() {
            @Override
            public void onClick() {
                LogUtils.d("返回",CombinationViewActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("onDestroy",this);
    }
}
