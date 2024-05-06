package com.example.pmd_se_a_java_2nd_file.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.example.pmd_se_a_java_2nd_file.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteMainActivity extends AppCompatActivity {
    DbTools dbTool;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_main);

        dbTool = new DbTools(getApplicationContext());
        listView = findViewById(R.id.lstmaincontactlist);

        ArrayList<HashMap<String, String>> contactList = dbTool.getAllContacts();

        SimpleAdapter adapter = new SimpleAdapter(this,
                contactList, R.layout.allcontactslayout,
                new String[]{"_id", "firstName", "secondName", "phoneNumber", "emailAddress"},
                new int[]{R.id.txtdbid, R.id.txtdbFirstName,
                        R.id.txtdbSecondName, R.id.txtdbPhoneNumber, R.id.txtdbEmailAddress});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SQLiteMainActivity.this,
                        EditContactEntry.class);

                intent.putExtra("id", String.valueOf(id));
                startActivity(intent);

            }
        });
    }

    public void AddContact(View view) {
        Intent intent = new Intent(SQLiteMainActivity.this,NewContactEntry.class);
        startActivity(intent);
    }
}
