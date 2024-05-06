package com.example.pmd_se_a_java_2nd_file.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.pmd_se_a_java_2nd_file.R;

import java.util.HashMap;

public class NewContactEntry extends AppCompatActivity {

    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    Button button;
    DbTools dbTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact_entery);

        firstName = findViewById(R.id.edtfirstname);
        secondName = findViewById(R.id.edtsecondname);
        phoneNumber = findViewById(R.id.edtphonenumber);
        emailAddress = findViewById(R.id.edtemail);
        homeAddress = findViewById(R.id.edthomeaddress);

        button = findViewById(R.id.btnsave);

        dbTools = new DbTools(getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String>contact = new HashMap<String,String>();

                contact.put("firstName",firstName.getText().toString());
                contact.put("secondName",secondName.getText().toString());
                contact.put("phoneNumber",phoneNumber.getText().toString());
                contact.put("emailAddress",emailAddress.getText().toString());
                contact.put("homeAddress",homeAddress.getText().toString());

                dbTools.AddContact(contact);
            }
        });

    }
}
