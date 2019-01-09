package org.harry.littleworld.api;

import android.app.Service;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zhanghai on 2019/1/8.
 * function：
 */
public interface ILittleWorldService {
    void attach(Service context);
    void onCreate();
    void onDestroy();
    int onStartCommand(Intent intent, int flags, int startId);
    boolean onUnbind(Intent intent);
    void onRebind(Intent intent);
}
