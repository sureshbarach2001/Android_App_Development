package com.example.pmd_se_a_java_2nd_file.SharedPrefrenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pmd_se_a_java_2nd_file.R;

import java.util.ArrayList;

public class SPExampleTwoSecondActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spexample_two_second);
        listView = findViewById(R.id.lstsharedperferences);
        SharedPreferences sharedPreferences = getSharedPreferences("MyFile3",0);
        String Oppo = sharedPreferences.getString("Oppo","");
        String Nokia = sharedPreferences.getString("Nokia","");
        String Iphone = sharedPreferences.getString("Iphone","");
        String Samgung = sharedPreferences.getString("Samsung","");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Oppo);
        arrayList.add(Nokia);
        arrayList.add(Iphone);
        arrayList.add(Samgung);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
    }
}