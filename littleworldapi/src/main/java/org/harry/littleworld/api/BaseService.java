package org.harry.littleworld.api;

import android.app.Service;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by zhanghai on 2019/1/8.
 * function：
 */
public abstract class BaseService extends Service implements ILittleWorldService {
    protected Service that = null;

    @Override
    public void attach(Service context) {
        that = context;
    }

    @Override
    public void onCreate() {
        if(that == null){
            super.onCreate();
        }
    }

    @Override
    public void onDestroy() {
        if(that == null){
            super.onDestroy();
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

}
