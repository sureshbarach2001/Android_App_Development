package com.example.pmd_se_a_java_2nd_file.Task2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pmd_se_a_java_2nd_file.R;

import java.util.concurrent.ExecutionException;

public class DownloadAndViewImageMainActivity extends AppCompatActivity{

    ImageView img1, img2, img3, img4;

    AsyncTask2 linker;
    Bitmap bitmap;
    boolean imagesVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_and_view_image_main);
        img1 = findViewById(R.id.imgview1);
        img2 = findViewById(R.id.imgview2);
        img3 = findViewById(R.id.imgview3);
        img4 = findViewById(R.id.imgview4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageVisibility(img1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageVisibility(img2);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageVisibility(img3);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageVisibility(img4);
            }
        });
    }

    public void Download(View view) {
        linker = new AsyncTask2();
        try {
            bitmap = linker.execute("https://images.pexels.com/photos/1598073/pexels-photo-1598073.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1").get();
            img1.setImageBitmap(bitmap);
            img2.setImageBitmap(bitmap);
            img3.setImageBitmap(bitmap);
            img4.setImageBitmap(bitmap);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void toggleImageVisibility(ImageView imageView) {
        if (imagesVisible) {
            imageView.setImageBitmap(null);
            imagesVisible = false;
        } else {
            imageView.setImageBitmap(bitmap);
            imagesVisible = true;
        }
    }
}