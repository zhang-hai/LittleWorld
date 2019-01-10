package com.harry.myapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;

import org.harry.littleworld.api.BaseService;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by zhanghai on 2019/1/8.
 * function：
 */
public class MyService extends BaseService implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer = null;

    @Override
    public void onCreate() {
//        super.onCreate();
        System.out.println("MyService --->> onCreate.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyService --->> onStartCommand.");
        initMedia();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        release();
        System.out.println("MyService --->> onDestroy(停止播放).");
    }


    private void initMedia(){
        if (mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
        }
        try {
            mediaPlayer.reset();
            String filepath = String.format(Locale.CHINESE,"%s/%s",Environment.getExternalStorageDirectory().getPath(),"Honor.mp3");
            mediaPlayer.setDataSource(filepath);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        if(mediaPlayer != null){
            if (mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        if (mp != null){
            System.out.println("MyService --->> onPrepared 播放.");
            mp.start();
        }
    }


}
