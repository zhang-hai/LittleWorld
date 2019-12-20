package com.harry.myapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.harry.myapp.service.MyService;

import org.harry.littleworld.api.BaseActivity;
import org.harry.littleworld.api.permission.PermissionUtil;

/**
 * Created by zhanghai on 2019/1/3.
 * function：
 */
public class MainActivity extends BaseActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hasPermission();

        findViewById(R.id.tv_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getCurrentContext(MainActivity.this),MyService.class));
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == CODE && resultCode == RESULT_OK){
//            showToast(MainActivity.this,"我返回自插件的DetailActivity类");
//        }
    }

    @Override
    public void onDestroy() {
        stopService(new Intent(getCurrentContext(MainActivity.this),MyService.class));
        super.onDestroy();

    }


    private void hasPermission(){
        PermissionUtil.grantNeedPermission(getCurrentContext(MainActivity.this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionUtil.REQUEST_CODE_APP_NEED:
                if (grantResults.length > 0) {
                    int count = grantResults.length;
                    int errorCount = 0;
                    int successCount = 0;
                    for (int result : grantResults) {
                        if (result == PackageManager.PERMISSION_GRANTED) {
                            successCount++;
                        } else {
                            errorCount++;
                        }
                    }
                }
                break;
        }
    }
}
