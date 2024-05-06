package com.example.pmd_se_a_java_2nd_file.CardViewExamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmd_se_a_java_2nd_file.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewMainActivity extends AppCompatActivity {
    public List<My_Model> list;
    public AdapterCardView adapterCardView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_main);
        recyclerView = findViewById(R.id.mycardviewrecyclerview);
        list = new ArrayList<>();
        adapterCardView = new AdapterCardView(this,list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterCardView);
        Insert();
    }
    public void Insert()
    {
        int[] thumbnails = new int[]
                {
                        R.drawable.pic,R.drawable.one,R.drawable.pic,
                        R.drawable.one,R.drawable.pic,R.drawable.one
                };
        My_Model myModel = new My_Model("My First Item",10,thumbnails[0]);
        list.add(myModel);
        myModel = new My_Model("My Second Item",10,thumbnails[1]);
        list.add(myModel);
        myModel = new My_Model("My Third Item",10,thumbnails[2]);
        list.add(myModel);
        myModel = new My_Model("My Fourth Item",10,thumbnails[3]);
        list.add(myModel);
        myModel = new My_Model("My Fifth Item",10,thumbnails[4]);
        list.add(myModel);
        myModel = new My_Model("My Sixth Item",10,thumbnails[5]);
        list.add(myModel);

    }
}