package com.example.pmd_se_a_java_2nd_file.SharedPrefrenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.pmd_se_a_java_2nd_file.R;

public class SPExampleTwoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spexample_two_main);
    }

    public void SavePref(View view) {
        SharedPreferences preferences = getSharedPreferences("MyFile3",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Iphone","Iphone 11");
        editor.putString("Nokia","Nokia 10");
        editor.putString("Samsung","Note 4");
        editor.putString("Oppo","Y13");
        editor.putString("Vivo","V13");
        editor.putString("Techno","Camon 15");
        editor.putString("Infinix","S4");
        editor.putString("Google","Pixel 7");
        Intent intent = new Intent(this, SPExampleTwoSecondActivity.class);
        startActivity(intent);
        if(preferences.contains("Oppo") && preferences.contains("Iphone"))
        {

        }

    }
}