package org.harry.littleworld;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.harry.littleworld.api.LittleWorldInterface;
import org.harry.littleworld.manager.PluginManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhanghai on 2019/1/3.
 * function：
 */
public class ProxyActivity extends Activity {
    private String className;

    private LittleWorldInterface littleWorldInterface = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        className = getIntent().getStringExtra("className");

        try {
            Class activityClass = getClassLoader().loadClass(className);
            Constructor constructor = activityClass.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});

            littleWorldInterface = (LittleWorldInterface) instance;
            littleWorldInterface.attach(this);

            littleWorldInterface.onCreate(savedInstanceState);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
        String classNameFromApk = intent.getStringExtra("className");
        Intent intent1 = new Intent(this,ProxyActivity.class);
        intent1.putExtra("className",classNameFromApk);
        super.startActivity(intent1);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        String classNameFromApk = intent.getStringExtra("className");
        Intent intent1 = new Intent(this,ProxyActivity.class);
        intent1.putExtra("className",classNameFromApk);
        super.startActivityForResult(intent1, requestCode);
    }
}
