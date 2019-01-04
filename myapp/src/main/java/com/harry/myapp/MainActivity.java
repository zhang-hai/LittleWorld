package com.harry.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import org.harry.littleworld.api.BaseActivity;

/**
 * Created by zhanghai on 2019/1/3.
 * function：
 */
public class MainActivity extends BaseActivity {
    private final int CODE = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_myapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getCurrentContext(MainActivity.this),DetailActivity.class);
                startActivityForResult(intent,CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE && resultCode == RESULT_OK){
            showToast(MainActivity.this,"我返回自插件的DetailActivity类");
        }
    }
}
