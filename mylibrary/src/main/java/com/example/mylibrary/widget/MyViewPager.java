package com.example.mylibrary.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/11/26.
 */

public class MyViewPager extends ViewPager {

    private boolean scroll = true;

    public MyViewPager(Context context) {
        this(context, null);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!scroll) {//设置viewPager是否可以滑动
            return true;
        }
        return super.onTouchEvent(ev);
    }

    public void setScrollable(boolean scrollable) {
        this.scroll = scrollable;
    }
}
