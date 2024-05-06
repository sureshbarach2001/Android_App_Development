package com.example.pmd_se_a_java_2nd_file.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmd_se_a_java_2nd_file.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    AdapterRecyclerView adapter;

    List<MyMobiles> mobilesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        recyclerView = findViewById(R.id.myrecyclerview);
        adapter = new AdapterRecyclerView(mobilesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        AddMobiles();


    }
    public void AddMobiles()
    {
        MyMobiles myMobilesobj = new MyMobiles("Iphone 12", "Apple", "400000");
        mobilesList.add(myMobilesobj);
        myMobilesobj = new MyMobiles("Iphone 13","Apple","500000");
        mobilesList.add(myMobilesobj);

        myMobilesobj = new MyMobiles("Vivo 13","Vivo","500000");
        mobilesList.add(myMobilesobj);
        myMobilesobj = new MyMobiles("Note 20","Samsung","500000");
        mobilesList.add(myMobilesobj);
        myMobilesobj = new MyMobiles("Note 10","Samsung","500000");
        mobilesList.add(myMobilesobj);
        adapter.notifyDataSetChanged();

    }
}