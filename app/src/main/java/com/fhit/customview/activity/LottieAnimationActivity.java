package com.fhit.customview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.fhit.customview.R;

public class LottieAnimationActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_animation);
        lottieAnimationView = (LottieAnimationView)findViewById(R.id.lottie_animation_view);

    }
}
