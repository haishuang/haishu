package com.example.mylibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Huang hai-sen on 2016/6/29 11:33.
 */
public class T {
    private T() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 为了防止Toast 反复弹出，引入变量
     */
    private static Toast toast = null;

    /***
     * 短时间Toast
     *
     * @param context
     * @param msg
     */
    public static void showShort(Context context, CharSequence msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /***
     * 短时间Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /***
     * 长时间Toast
     *
     * @param context
     * @param msg
     */
    public static void showLong(Context context, CharSequence msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /***
     * 长时间Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
