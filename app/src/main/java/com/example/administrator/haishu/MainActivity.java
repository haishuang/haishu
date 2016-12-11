package com.example.administrator.haishu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.haishu.mine.MineFragment;
import com.example.administrator.haishu.news.NewsFragment;
import com.example.mylibrary.widget.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends FragmentActivity {
    private final int REQUEST_CODE_CALL_PHONE = 11;

    @Bind(R.id.tv_call)
    TextView tvCall;
    @Bind(R.id.iv_main_news)
    ImageView ivMainNews;
    @Bind(R.id.iv_main_mine)
    ImageView ivMainMine;
    @Bind(R.id.vp)
    MyViewPager vp;

    private List<Fragment> fragments = new ArrayList<>();
    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ivMainMine.setEnabled(true);
        ivMainNews.setEnabled(false);
        fragments.add(new NewsFragment());
        fragments.add(new MineFragment());
        //设置不可滑动
        vp.setScrollable(false);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        vp.setOffscreenPageLimit(1);//缓存页面个数
        vp.setCurrentItem(0);//默认选中第一个
        vp.setAdapter(adapter);
    }

//    //写一个打电话的方法
//    void callPhone() {
//        //先检查是否有权限
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            //申请权限
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL_PHONE);
//        } else {
//            doCallPhone();
//        }
//    }
//
//    //申请完权限后回调
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 1:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    doCallPhone();
//                } else {
//                    //提示用户权限未被授予，退出
//                }
//                break;
//        }
//    }
//
//    void doCallPhone() {
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        Uri uri = Uri.parse("tel:" + "10086");
//        intent.setData(uri);
//        startActivity(intent);
//    }


//    @OnClick(R.id.tv_call)
//    public void onClick() {
//        callPhone();
//    }

    @OnClick({R.id.iv_main_news, R.id.iv_main_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_main_news:
                ivMainMine.setEnabled(true);
                ivMainNews.setEnabled(false);
                vp.setCurrentItem(0);
                break;
            case R.id.iv_main_mine:
                ivMainMine.setEnabled(false);
                ivMainNews.setEnabled(true);
                vp.setCurrentItem(1);
                break;
        }
    }
}
