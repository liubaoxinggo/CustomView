package com.fhit.customview;

import android.app.Application;

import com.fhit.customview.util.Utils;

/**
 * Created by liubaoxing on 2018/3/15 17:15<br/>
 * Email:liubaoxinggo@foxmail.com<br/>
 */

public class TApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
