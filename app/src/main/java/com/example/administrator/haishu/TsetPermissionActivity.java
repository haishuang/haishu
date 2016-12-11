package com.example.administrator.haishu;

import android.Manifest;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.haishu.common.Contant;

public class TsetPermissionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tset_permission);

        //当用到SD卡权限时
        if(hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            doSDCardPermission();
        }else {
            requestPermission(Contant.WRITE_EXTERNAL_CODE,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        //当用到打电话权限时
        if(hasPermission(Manifest.permission.CALL_PHONE)){
            doSDCardPermission();
        }else {
            requestPermission(Contant.CALL_PHONE_CODE,Manifest.permission.CALL_PHONE);
        }




    }

    //通过子类去实现SD权限逻辑
    @Override
    public void doSDCardPermission(){

    }
    //通过子类去实现打电话逻辑
    @Override
    public void doCallPhonePermission(){

    }

    /*
    //写一个打电话的方法
    void callPhone() {
        //先检查是否有权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL_PHONE);
        } else {
            doCallPhone();
        }
    }

    //申请完权限后回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    doCallPhone();
                } else {
                    //提示用户权限未被授予，退出
                }
                break;
        }
    }

    void doCallPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + "10086");
        intent.setData(uri);
        startActivity(intent);
    }


    @OnClick(R.id.tv_call)
    public void onClick() {
        callPhone();
    }*/
}
