package com.example.pmd_se_a_java_2nd_file.ServiceExamples.BoundServiceExamples;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmd_se_a_java_2nd_file.R;

public class BoundServiceMainActivity extends AppCompatActivity {



    MyBoundService myBoundServicePlayer;
    public boolean myBoundService = false;

    public ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundServicePlayer = myBinder.getServiceMethod();
            myBoundService = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, myServiceConnection, BIND_AUTO_CREATE);
    }

    public void PlayMusic(View view) {
        if ( myBoundService == true ){
            if ( myBoundServicePlayer.isPlaying()){
                myBoundServicePlayer.Pause();
            } else {
                myBoundServicePlayer.Play();
            }
        }
    }
}