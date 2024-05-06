package com.example.pmd_se_a_java_2nd_file.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.pmd_se_a_java_2nd_file.R;

import java.util.HashMap;

public class EditContactEntry extends AppCompatActivity {

    DbTools dbTools;
    EditText updatedfirstName, updatedsecondName, updatedphoneNumber, updatedemailAddress, updatedhomeAddress;
    Button btnEdit, btnDelete;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_entry);

        btnEdit = findViewById(R.id.btnupdate);
        btnDelete = findViewById(R.id.btndelete);

        updatedfirstName = findViewById(R.id.editfirstname);
        updatedsecondName = findViewById(R.id.editsecondname);
        updatedphoneNumber = findViewById(R.id.editphonenumber);
        updatedemailAddress = findViewById(R.id.editemailaddress);
        updatedhomeAddress = findViewById(R.id.edithomeaddress);

        dbTools = new DbTools(getApplicationContext());
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        HashMap<String, String> singleContact = dbTools.getSingleContact(id);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String>contact = new HashMap<String,String>();

                contact.put("firstName", updatedfirstName.getText().toString());
                contact.put("secondName", updatedsecondName.getText().toString());
                contact.put("phoneNumber", updatedphoneNumber.getText().toString());
                contact.put("emailAddress", updatedemailAddress.getText().toString());
                contact.put("homeAddress", updatedhomeAddress.getText().toString());

                String conID = dbTools.getSpecificContactID(id);
                int nextID = Integer.parseInt(conID);

                dbTools.UpdateContact(contact, (nextID + 1) + "");
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String conID = dbTools.getSpecificContactID(id);
                int nextID = Integer.parseInt(conID);

                dbTools.DeleteContact((nextID + 1) + "");
            }
        });
    }
}
