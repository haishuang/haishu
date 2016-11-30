package com.example.mylibrary.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mylibrary.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/11/28.
 */

public class TopBar extends LinearLayout {
    private ImageView ivTopBack;
    private TextView tvTopBack;
    private RelativeLayout rlTopBack;
    private TextView tvTopTitle;
    private TextView tvTopMore;
    private LinearLayout llTop;
    private View view;

    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.topbar, null);
        addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //requestLayout();
    }

    /**
     * 设置返回箭头图标
     */
    public void setIvTopBack(@NonNull int resId) {
        getIvTopBack();
        ivTopBack.setImageResource(resId);
    }

    /**
     * 设置返回按钮的文字
     *
     * @param resId
     */
    public void setTvTopBack(@NonNull int resId) {
        getTvTopBack();
        tvTopBack.setText(resId);
    }

    /**
     * 设置背景色
     *
     * @param color
     */
    public void setRlTopBackBackground(@NonNull int color) {
        getRlTopBack();
        rlTopBack.setBackgroundColor(color);
    }

    /**
     * 设置中间标题文字
     *
     * @param str
     */
    public void setTvTopTitle(String str) {
        getTvTopTitle();
        tvTopTitle.setText(str);
    }

    /**
     * 更多的文字设置
     *
     * @param str
     */
    public void setTvTopMore(String str) {
        getTvTopMore();
        tvTopMore.setText(str);
    }

    public TextView getTvTopBack() {
        if (tvTopBack == null) {
            tvTopBack = (TextView) view.findViewById(R.id.tv_top_back);
        }
        return tvTopBack;
    }

    public ImageView getIvTopBack() {
        if (ivTopBack == null) {
            ivTopBack = (ImageView) view.findViewById(R.id.iv_top_back);
        }
        return ivTopBack;
    }


    public RelativeLayout getRlTopBack() {
        if (rlTopBack == null) {
            rlTopBack = (RelativeLayout) view.findViewById(R.id.rl_top_back);
        }
        return rlTopBack;
    }

    public TextView getTvTopTitle() {
        if (tvTopTitle == null) {
            tvTopTitle = (TextView) view.findViewById(R.id.tv_top_title);
        }
        return tvTopTitle;
    }

    public TextView getTvTopMore() {
        if (tvTopMore == null) {
            tvTopMore = (TextView) view.findViewById(R.id.tv_top_more);
        }
        return tvTopMore;
    }

    public LinearLayout getLlTop() {
        if (llTop == null) {
            llTop = (LinearLayout) view.findViewById(R.id.ll_top);
        }
        return llTop;
    }
}
