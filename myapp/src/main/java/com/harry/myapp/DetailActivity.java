package com.harry.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.harry.littleworld.api.BaseActivity;

/**
 * Created by zhanghai on 2019/1/3.
 * function：
 */
public class DetailActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        findViewById(R.id.imgbg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
