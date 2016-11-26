package com.example.mylibrary.utils;

import android.util.Log;

/**
 * Created by Huang hai-sen on 2016/6/28 18:03.
 * 使用此方法不仅能快速开发，而且还能很好的控制，当打包编译是只需改一下isDebug即可。
 */
public class L {
    private L() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;
    private final static String TAG = "haishu";

    public static void v(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void i(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void w(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }
}
