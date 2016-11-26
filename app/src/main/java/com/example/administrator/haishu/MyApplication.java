package com.example.administrator.haishu;

import android.app.Application;

import com.example.mylibrary.utils.CrashHandlerUtils;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandlerUtils crashHandler = CrashHandlerUtils.getInstance();
        crashHandler.init(this);
    }
}
