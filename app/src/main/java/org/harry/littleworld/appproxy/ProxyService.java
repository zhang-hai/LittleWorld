package org.harry.littleworld.appproxy;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.support.annotation.Nullable;

import org.harry.littleworld.api.ILittleWorldService;
import org.harry.littleworld.api.LittleWorldConstantApi;
import org.harry.littleworld.manager.PluginManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhanghai on 2019/1/8.
 * function：
 */
public class ProxyService extends Service {

    private ILittleWorldService littleWorldService = null;

    private String className;//要启动的Service的类名称

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null){
            className = intent.getStringExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME);
            loadClassFromName(className);
            if(littleWorldService != null){
                littleWorldService.onCreate();
                return littleWorldService.onStartCommand(intent,flags,startId);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        if(littleWorldService != null){
            littleWorldService.onDestroy();
        }
        super.onDestroy();
    }

    /**
     * 根据类名称加载类
     * @param clsName
     */
    private void loadClassFromName(String clsName) {
        Class activityClass = null;
        try {
            activityClass = getClassLoader().loadClass(clsName);
            Constructor constructor = activityClass.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});
            if (instance instanceof ILittleWorldService) {
                littleWorldService = (ILittleWorldService) instance;
                littleWorldService.attach(this);
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
}
