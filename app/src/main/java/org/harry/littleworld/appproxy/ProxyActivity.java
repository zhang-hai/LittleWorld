package org.harry.littleworld.appproxy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.harry.littleworld.api.LittleWorldConstantApi;
import org.harry.littleworld.api.ILittleWorldActivity;
import org.harry.littleworld.manager.PluginManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhanghai on 2019/1/3.
 * function：
 */
public class ProxyActivity extends Activity {
    private String className;

    private ILittleWorldActivity littleWorldInterface = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        className = getIntent().getStringExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME);

        loadClassFromName(className);

        if(littleWorldInterface != null){
            littleWorldInterface.onCreate(savedInstanceState);
        }
    }

    /**
     * 根据类名称加载类
     * @param clsName
     */
    private void loadClassFromName(String clsName){
        Class activityClass = null;
        try {
            activityClass = getClassLoader().loadClass(clsName);
            Constructor constructor = activityClass.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});
            if(instance instanceof ILittleWorldActivity){
                littleWorldInterface = (ILittleWorldActivity) instance;
                littleWorldInterface.attach(this);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().getDexClassLoader();
    }

    @Override
    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }

    @Override
    public void startActivity(Intent intent) {
        String classNameFromApk = intent.getStringExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME);
        Intent intent1 = new Intent(this,ProxyActivity.class);
        intent1.putExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME,classNameFromApk);
        super.startActivity(intent1);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        String classNameFromApk = intent.getStringExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME);
        Intent intent1 = new Intent(this,ProxyActivity.class);
        intent1.putExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME,classNameFromApk);
        super.startActivityForResult(intent1, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(littleWorldInterface == null){
            super.onActivityResult(requestCode, resultCode, data);
        }else {
            littleWorldInterface.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public ComponentName startService(Intent service) {
        String clsName = service.getStringExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME);
        Intent intent = new Intent(this,ProxyService.class);
        intent.putExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME,clsName);
        return super.startService(intent);
    }

    @Override
    public boolean stopService(Intent name) {
        String clsName = name.getStringExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME);
        Intent intent = new Intent(this,ProxyService.class);
        intent.putExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME,clsName);
        return super.stopService(intent);
    }
}
