package com.example.pmd_se_a_java_2nd_file.BroadCastReciever;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmd_se_a_java_2nd_file.R;

public class BroadCastExampleOneMainActivity extends AppCompatActivity {

    AirPlaneModeChangeReceiver myBroadCast = new AirPlaneModeChangeReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_example_one_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myBroadCast,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadCast);
    }
}