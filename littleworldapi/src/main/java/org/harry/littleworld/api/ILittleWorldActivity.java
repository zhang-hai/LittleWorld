package org.harry.littleworld.api;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

/**
 * Created by zhanghai on 2019/1/3.
 * function：定义一个公共的生命周期接口
 */
public interface ILittleWorldActivity {
    void attach(FragmentActivity activity);
    void onCreate(@Nullable Bundle savedInstanceState);
    void onResume();
    void onStart();
    void onRestart();
    void onPause();
    void onStop();
    void onDestroy();
    void onBackPressed();
    void finish();
    boolean onTouchEvent(MotionEvent event);
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void setActivityResult(int resultCode);
    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
}
