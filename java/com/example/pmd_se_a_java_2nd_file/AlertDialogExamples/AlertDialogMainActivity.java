package com.example.pmd_se_a_java_2nd_file.AlertDialogExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmd_se_a_java_2nd_file.R;

public class AlertDialogMainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_main);
        button = findViewById(R.id.btnalertdialog);
        textView = findViewById(R.id.txtalertdialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =
                new AlertDialog.Builder(AlertDialogMainActivity.this);
                builder.setMessage("Are You Sure...").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("2000");
                    }
                })
                        .setNegativeButton("Cancel",null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}