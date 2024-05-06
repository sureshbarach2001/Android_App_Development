package com.example.pmd_se_a_java_2nd_file.SharedPrefrenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmd_se_a_java_2nd_file.R;
import com.google.android.material.snackbar.Snackbar;

public class SharedPrefrenceExampleOne extends AppCompatActivity {

    SharedPreferences sharedPrefrences;

    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrence_example_one);
        sharedPrefrences = getSharedPreferences("MyFile2",0);
        textView = findViewById(R.id.txtsharedprefrence);
        editText = findViewById(R.id.adtshredprefrence);

    }

    public void SaveMySharedPreferences(View view)
    {
        SharedPreferences.Editor editor=sharedPrefrences.edit();
        String data = editText.getText().toString();
        editor.putString("KEY",data);
        //editor.putInt("A",100);
        //editor.putString("B","Ali");
        editor.commit();
        Snackbar.make(view,"Saved",Snackbar.LENGTH_SHORT).show();

    }

    public void ShowMySharedPreferences(View view)
    {
        //int value = sharedPrefrences.getInt("A",0);
        //String value2 = sharedPrefrences.getString("B","No Value");
        textView.setText(sharedPrefrences.getString("KEY","No Value"));
    }
}