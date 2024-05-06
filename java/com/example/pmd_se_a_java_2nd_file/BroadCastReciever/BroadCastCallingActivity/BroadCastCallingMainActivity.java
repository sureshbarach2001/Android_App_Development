package com.example.pmd_se_a_java_2nd_file.BroadCastReciever.BroadCastCallingActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pmd_se_a_java_2nd_file.R;

public class BroadCastCallingMainActivity extends AppCompatActivity {

    private BroadcastReceiver callReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.example.pmd_se_a_java_2nd_file.CALL_RECEIVED")) {
                String incomingNumber = intent.getStringExtra("incoming_number");
                // Do something with the incoming number, e.g., display a toast
                Toast.makeText(context, "Incoming call from: " + incomingNumber, Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_calling_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.pmd_se_a_java_2nd_file.CALL_RECEIVED");
        registerReceiver(callReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(callReceiver);
    }
}