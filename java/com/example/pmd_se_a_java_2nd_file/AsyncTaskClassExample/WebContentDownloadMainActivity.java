package com.example.pmd_se_a_java_2nd_file.AsyncTaskClassExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.pmd_se_a_java_2nd_file.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.concurrent.ExecutionException;

public class WebContentDownloadMainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content_download_main);

        editText = findViewById(R.id.edtmultilineweb);
    }

    public void Download_WebContent(View view) {
        DownloadWebContent obj = new DownloadWebContent();
        try {
            String webContent = obj.execute("https://www.google.com").get();
            Log.d("TAG", "Back in main activity");

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    class DownloadWebContent extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Log.d("TAG", "doInBackground in Progress!");

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();
                String webContent = "";
                while( data!= -1 ) {
                    char c = (char) data;
                    webContent = webContent + c;
                    data = reader.read();
                }
                return webContent;

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}