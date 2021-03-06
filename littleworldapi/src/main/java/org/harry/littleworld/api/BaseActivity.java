package org.harry.littleworld.api;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by zhanghai on 2019/1/3.
 * function：BaseActivity
 */
public class BaseActivity extends FragmentActivity implements ILittleWorldActivity {

    protected  FragmentActivity that = null;

    @Override
    public void attach(FragmentActivity activity) {
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
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        if(that == null){
            super.onPostCreate(savedInstanceState);
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
    public Resources getResources() {
        if(that == null){
            return super.getResources();
        }else {
            return that.getResources();
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
            that.startActivity(intent);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if(that == null){
            super.startActivityForResult(intent, requestCode);
        }else {
            that.startActivityForResult(intent,requestCode);
        }
    }

    @Override
    public ComponentName startService(Intent service) {
        if(that == null){
            return super.startService(service);
        }else {
            return that.startService(service);
        }
    }

    @Override
    public boolean stopService(Intent name) {
        if(that == null){
            return super.stopService(name);
        }else {
            return that.stopService(name);
        }
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        if(that == null){
            return super.bindService(service, conn, flags);
        }else {
            return that.bindService(service, conn, flags);
        }
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        if(that == null){
            super.unbindService(conn);
        }else {
            that.unbindService(conn);
        }
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        if(that == null){
            return super.registerReceiver(receiver, filter);
        }else {
            return that.registerReceiver(receiver, filter);
        }
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        if(that == null){
            super.unregisterReceiver(receiver);
        }else {
            that.unregisterReceiver(receiver);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(that == null){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        if(that == null){
            return super.getSupportFragmentManager();
        }else {
            return that.getSupportFragmentManager();
        }
    }




    @Override
    public AssetManager getAssets() {
        if(that == null){
            return super.getAssets();
        }else {
            return that.getAssets();
        }
    }

    @Override
    public Context getApplicationContext() {
        if(that == null){
            return super.getApplicationContext();
        }else {
            return that.getApplicationContext();
        }
    }

    @Override
    public LoaderManager getSupportLoaderManager() {
        if(that == null){
            return super.getSupportLoaderManager();
        }else {
            return that.getSupportLoaderManager();
        }
    }
}
