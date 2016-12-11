package com.example.administrator.haishu;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.haishu.common.Contant;

/**
 * Created by Administrator on 2016/12/11.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * 提供一个权限检查方法
     * @param permissions
     * @return
     */
    public boolean hasPermission(String... permissions){

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        for(String permission:permissions){
            if(ContextCompat.checkSelfPermission(this,permission)
                    != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    /**
     * 为子类提供一个权限请求方法
     * @param code
     * @param permissions
     */
    public void requestPermission(int code,String... permissions){
        ActivityCompat.requestPermissions(this,permissions,code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case Contant.WRITE_EXTERNAL_CODE:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    doSDCardPermission();
                }else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    }
                        toast();
                }
            break;
            case Contant.CALL_PHONE_CODE:
                doCallPhonePermission();
            break;
            default:
                break;
        }
    }

    void toast(){
        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
    }

    /**
     * 默认的打电话权限处理
     */
    public void doCallPhonePermission() {

    }

    /**
     * 默认实现SD卡权限处理
     */
    public void doSDCardPermission() {

    }
}
