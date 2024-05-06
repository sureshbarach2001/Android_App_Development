package com.example.pmd_se_a_java_2nd_file.ServiceExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pmd_se_a_java_2nd_file.R;

public class ServiceExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example_one_main);
    }

    public void Start_Service(View view) {
        Intent intent = new Intent(this,MyServerExampleOne.class);
        startService(intent);
    }

    public void Stop_Service(View view) {
        Intent intent = new Intent(this,MyServerExampleOne.class);
        stopService(intent);
    }
}