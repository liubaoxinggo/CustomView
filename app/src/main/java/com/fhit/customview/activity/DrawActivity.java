package com.fhit.customview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fhit.customview.R;
import com.fhit.customview.custom.CounterView;
import com.fhit.customview.util.LogUtils;

public class DrawActivity extends AppCompatActivity {



    CounterView mCountView1,mCountView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        mCountView1 = (CounterView)findViewById(R.id.counter_view);
        mCountView2 = (CounterView)findViewById(R.id.counter_view_gc);

        mCountView1.setZ(1.0f);
        mCountView2.setZ(2.0f);

        findViewById(R.id.op).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float z1 = mCountView1.getZ();
                float z2 = mCountView2.getZ();
                LogUtils.d("z1 : "+z1,"z2 : "+z2);
                mCountView1.setZ(z2);
                mCountView2.setZ(z1);
            }
        });
    }
}
