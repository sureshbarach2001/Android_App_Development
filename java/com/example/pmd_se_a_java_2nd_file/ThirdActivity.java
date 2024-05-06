package com.example.pmd_se_a_java_2nd_file;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;


public class ThirdActivity extends AppCompatActivity {
    TextView textview;
    String firstValue;
    String secondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textview = findViewById(R.id.txtsecondactivity);
        Intent intent = getIntent();
        firstValue = intent.getStringExtra("A");
        secondValue = intent.getStringExtra("B");
        //Toast.makeText(this,firstValue,Toast.LENGTH_SHORT).show();

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        textview.setText(firstValue+"  "+secondValue);
    }
}