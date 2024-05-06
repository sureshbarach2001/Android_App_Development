//package com.example.pmd_se_a_java_2nd_file.ListViewExamples.ImageandTextViewExample;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import com.example.pmd_se_a_java_2nd_file.R;
//
//public class ImageAndTextMainActivity extends AppCompatActivity {
//
//    ListView listView;
//    String[] Name = {"Ali" , "Rizwan", "Abid","Hussain","Ahmed"};
//    String[] Text = {"Message From Ali" , "Message From Rizwan", "Message From Abid","Message From Hussain","Message From Ahmed"};
//
//    Integer[] Image= {R.drawable.icon,R.drawable.icon,R.drawable.icon,
//            R.drawable.icon,R.drawable.icon};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image_and_text_main);
//        listView = findViewById(R.id.lstimageandtext);
//        ImageAndTextAdapter adapter = new ImageAndTextAdapter(this,Name,Text,Image);
//        listView.setAdapter(adapter);
//    }
//}