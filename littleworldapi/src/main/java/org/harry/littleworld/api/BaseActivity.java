package org.harry.littleworld.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by zhanghai on 2019/1/3.
 * function：BaseActivity
 */
public class BaseActivity extends Activity implements LittleWorldInterface {

    protected  Activity that = null;

    @Override
    public void attach(Activity activity) {
        this.that = activity;
    }

    /**
     * 转换上下文
     * @param curActivity
     * @return
     */
    public Activity getCurrentContext(Activity curActivity){
        return that == null ? curActivity : that;
    }

    public void showToast(Activity activity,String msg){
        Toast.makeText(getCurrentContext(activity),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if(that == null){
            super.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        if(that == null){
            super.onResume();
        }
    }

    @Override
    public void onStart() {
        if(that == null){
            super.onStart();
        }
    }

    @Override
    public void onRestart() {
        if(that == null){
            super.onRestart();
        }
    }

    @Override
    public void onPause() {
        if(that == null){
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if(that == null){
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if(that == null){
            super.onDestroy();
        }
    }

    @Override
    public void onBackPressed() {
        if(that == null){
            super.onBackPressed();
        }else {
            that.onBackPressed();
        }
    }

    @Override
    public void finish() {
        if(that == null){
            super.finish();
        }else {
            that.finish();
        }
    }

    public void setActivityResult(int resultCode){
        if (that == null){
            setResult(resultCode);
        }else {
            that.setResult(resultCode);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(that == null){
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (that == null){
            super.setContentView(layoutResID);
        }else {
            that.setContentView(layoutResID);
        }
    }

    @Override
    public <T extends View> T findViewById(@IdRes int id) {
        if(that == null){
            return super.findViewById(id);
        }else {
            return that.findViewById(id);
        }
    }

    @Override
    public Window getWindow() {
        if(that == null){
            return super.getWindow();
        }else {
            return that.getWindow();
        }
    }

    @Override
    public WindowManager getWindowManager() {
        if(that == null){
            return super.getWindowManager();
        }else {
            return that.getWindowManager();
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        if(that == null){
            return super.getClassLoader();
        }else {
            return that.getClassLoader();
        }
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        if(that == null){
            return super.getLayoutInflater();
        }else {
            return that.getLayoutInflater();
        }
    }

    @Override
    public void startActivity(Intent intent) {
        if (that == null){
            super.startActivity(intent);
        }else {
            Intent newIntent = new Intent();
            newIntent.putExtra("className",intent.getComponent().getClassName());
            that.startActivity(newIntent);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if(that == null){
            super.startActivityForResult(intent, requestCode);
        }else {
            Intent newIntent = new Intent();
            newIntent.putExtra("className",intent.getComponent().getClassName());
            that.startActivityForResult(newIntent,requestCode);
        }
    }
}
