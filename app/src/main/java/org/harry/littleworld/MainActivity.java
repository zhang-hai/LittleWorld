package org.harry.littleworld;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.harry.littleworld.manager.PluginManager;
import org.harry.littleworld.permission.PermissionUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button btn_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_load = findViewById(R.id.btn_load);

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(Environment.getExternalStorageDirectory(),"myapp.apk");
                PluginManager.getInstance().loadApk(getApplicationContext(),file.getAbsolutePath());

                Intent intent = new Intent(MainActivity.this,ProxyActivity.class);
                intent.putExtra("className",PluginManager.getInstance().getEntryActivityName());
                startActivity(intent);
            }
        });

        hasPermission();
    }

    private void hasPermission(){
        PermissionUtil.grantNeedPermission(this);
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
                    if (errorCount > 0) {
//                        finish();
//                        android.os.Process.killProcess(android.os.Process.myPid());
//                        System.gc();
                    }
                }
                break;
        }
    }
}
