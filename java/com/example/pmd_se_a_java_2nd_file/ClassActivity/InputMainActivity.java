package com.example.pmd_se_a_java_2nd_file.ClassActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmd_se_a_java_2nd_file.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class InputMainActivity extends AppCompatActivity {
    EditText Name, Company, Price;
    DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_main);
        Name = findViewById(R.id.edittextname);
        Company = findViewById(R.id.edittexttompany);
        Price = findViewById(R.id.edittextprice);
        dbReference = FirebaseDatabase.getInstance("https://pmd-se-a-java-2nd-file-default-rtdb.firebaseio.com/").getReference("Student");
    }
    public void save(View view) {
        String nameValue = Name.getText().toString();
        String companyValue = Company.getText().toString();
        String prizeValue = Price.getText().toString();

        HashMap<String, Object> userData = new HashMap<>();
        userData.put("Name", nameValue);
        userData.put("Company", companyValue);
        userData.put("Prize", prizeValue);
        String key = dbReference.push().getKey();
        dbReference.child("key").setValue("nameValue");
        Log.d("TAG","key"+key +" ::: "+ dbReference);
        if (key != null) {
            dbReference.child("key").setValue("nameValue");
            Log.d("TAG","data"+ nameValue);
            Name.setText("");
            Company.setText("");
            Price.setText("");

            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Failed to save data. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}