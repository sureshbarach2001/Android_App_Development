package com.example.pmd_se_a_java_2nd_file;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG","On Create is Called");
    }

    protected void onResume() {
        super.onResume();
        Log.d("TAG","onResume is Called");
    }

    protected void onStart() {
        super.onStart();
        Log.d("TAG","On Start is Called");
    }

    protected void onStop(){
        super.onStop();
    }

    protected void onPause(){
        super.onPause();
        Log.d("TAG","On Pause is Called");
    }

    public void Next(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("A","First Value");
        intent.putExtra("B","Second Value");
        startActivity(intent);
//        Toast.makeText(this, "This is My First Toast", Toast.LENGTH_SHORT).show();
//        Snackbar.make(view,"This is My First Snackbar", Snackbar.LENGTH_SHORT).show();
    }
}