//package com.example.pmd_se_a_java_2nd_file.ListViewExamples;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import com.example.pmd_se_a_java_2nd_file.R;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class MultiColumnListViewMainActivity extends AppCompatActivity {
//    ListView listView;
//    public ArrayList<HashMap<String,String>> list;
//    public static final String First_Column = "First";
//    public static final String Second_Column = "Second";
//    public static final String Third_Column = "Third";
//    public static final String Fourth_Column = "Fourth";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_multi_column_list_view_main);
//        listView = findViewById(R.id.mylstmulticolumn);
//        LoadValues();
//        MyListAdapter adapter = new MyListAdapter(list, this);
//        listView.setAdapter(adapter);
//    }
//
//    public void LoadValues()
//    {
//        list = new ArrayList<HashMap<String,String>>();
//        HashMap<String,String> hashMap1 = new HashMap<>();
//        hashMap1.put(First_Column, "Ali");
//        hashMap1.put(Second_Column,"Ahmad");
//        hashMap1.put(Third_Column,"Arbaz");
//        hashMap1.put(Fourth_Column,"Daniyal");
//        list.add(hashMap1);
//
//        HashMap<String,String> hashMap2 = new HashMap<>();
//        hashMap2.put(First_Column, "Ali");
//        hashMap2.put(Second_Column,"Ahmad");
//        hashMap2.put(Third_Column,"Arbaz");
//        hashMap2.put(Fourth_Column,"Daniyal");
//        list.add(hashMap2);
//
//        HashMap<String,String> hashMap3 = new HashMap<>();
//        hashMap3.put(First_Column, "Ali");
//        hashMap3.put(Second_Column,"Ahmad");
//        hashMap3.put(Third_Column,"Arbaz");
//        hashMap3.put(Fourth_Column,"Daniyal");
//        list.add(hashMap3);
//
//        HashMap<String,String> hashMap4 = new HashMap<>();
//        hashMap4.put(First_Column, "Ali");
//        hashMap4.put(Second_Column,"Ahmad");
//        hashMap4.put(Third_Column,"Arbaz");
//        hashMap4.put(Fourth_Column,"Daniyal");
//        list.add(hashMap4);
//
//    }
//}