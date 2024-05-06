package com.example.pmd_se_a_java_2nd_file.FirebaseExamples;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmd_se_a_java_2nd_file.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseExampleOneMainActivity extends AppCompatActivity {

    DatabaseReference myReference;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example_one_main);
        textView = findViewById(R.id.txtfirebase);
        FirebaseDatabase database = FirebaseDatabase
                .getInstance("https://pmd-se-a-java-2nd-file-default-rtdb.firebaseio.com/");
        myReference = database.getReference();
       // myReference.setValue("This is first Value");

    }

    public void Send(View view) {
        myReference.setValue("The First value to be retrieve");
//        myReference.child("BSSE").child("PMD").child("Student 1").setValue("Suresh");
//        myReference.child("BSCS").child("SMD").child("Student 2").setValue("Ahmad");
    }

    public void RetrieveValue(View view) {
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String value= snapshot.getValue().toString();
//                textView.setText(value);
                if(snapshot.getValue()!=null)
                {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                        String value = (String) dataSnapshot.getValue();
                        textView.setText(value + " ");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}