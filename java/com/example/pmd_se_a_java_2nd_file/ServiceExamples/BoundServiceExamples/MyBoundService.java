package com.example.pmd_se_a_java_2nd_file.ServiceExamples.BoundServiceExamples;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.pmd_se_a_java_2nd_file.R;

public class MyBoundService  extends Service {
    public Binder mybinder = new MyBinder();
    public MediaPlayer mediaPlayer;

    public MyBoundService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
    }


    public void Play(){
        mediaPlayer.start();
    }

    public void Pause(){
        mediaPlayer.pause();
    }

    public boolean isPlaying(){
        return mediaPlayer.isPlaying();
    }

    public void Stop(){
        mediaPlayer.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder{
        MyBoundService getServiceMethod() {
            return MyBoundService.this;
        }
    }
}