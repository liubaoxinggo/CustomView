package com.fhit.customview.custom;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fhit.customview.R;

/**
 * Created by liubaoxing on 2018/3/16 10:25<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class TitleView extends RelativeLayout {

    private Button mLeftBtn;

    private TextView mTitleTv;

    private MOnClickListener mOnClickListener;

    public TitleView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.titleview,this);

        mLeftBtn = (Button)findViewById(R.id.left_btn);

        mTitleTv = (TextView)findViewById(R.id.title_tv);

        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
                if(mOnClickListener != null){
                    mOnClickListener.onClick();
                }
            }
        });
    }
    public void setTitle(String title){
        mTitleTv.setText(title);
    }
    public void setLeftBtnText(String info){
        mLeftBtn.setText(info);
    }
    public void setLeftBtnOnClickListener(MOnClickListener listener){
        mOnClickListener = listener;
    }
    public interface MOnClickListener{
        public void onClick();
    }
}
