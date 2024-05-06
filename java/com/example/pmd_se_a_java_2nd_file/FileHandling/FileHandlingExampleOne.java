package com.example.pmd_se_a_java_2nd_file.FileHandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmd_se_a_java_2nd_file.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileHandlingExampleOne extends AppCompatActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling_example_one);
        editText = findViewById(R.id.edtfilehandling);
        textView = findViewById(R.id.txtfilehandling);

    }

    public void SaveIntoFile(View view)
    {
        String Data = editText.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("MyTextFile", Context.MODE_PRIVATE);
            fileOutputStream.write(Data.getBytes());
            Snackbar.make(view,"Data Saved", Snackbar.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void ShowFromFile(View view)
    {
        String ReadData = "";
        try {
            FileInputStream inputStream = openFileInput("MyTextFile");
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String value = bufferedReader.readLine();
            if (value == null)
            {
                Snackbar.make(view,"No Value", Snackbar.LENGTH_SHORT).show();
            }
            else
            {
                while(value != null)
                {
                    ReadData = ReadData + value;
                    value = bufferedReader.readLine();
                }
                bufferedReader.close();
                reader.close();
                inputStream.close();
            }
            textView.setText(ReadData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}