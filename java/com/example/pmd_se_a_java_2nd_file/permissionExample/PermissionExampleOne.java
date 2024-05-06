package com.example.pmd_se_a_java_2nd_file.permissionExample;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission_group.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pmd_se_a_java_2nd_file.R;
import com.google.android.material.snackbar.Snackbar;

public class PermissionExampleOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_example_one);
    }

    public void RequestPermission(View view) {
        if(!Check_Permission())
        {
            Request_Permission();
        }else {
            Toast.makeText(this,"Permission Already Granted",Toast.LENGTH_SHORT).show();
        }
    }
    public boolean Check_Permission(){
        int result1 = ContextCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION);
        int result2 = ContextCompat.checkSelfPermission(this, CAMERA);

        return result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED;
    }
    public void Request_Permission(){
        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION,CAMERA},101);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
        }
    }

    public void CheckPermission(View view) {
        if(!Check_Permission())
        {
            Toast.makeText(this,"Please Request for Permission",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Permission Already Granted",Toast.LENGTH_SHORT).show();
        }
    }

    public void ContactsPermission(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},102);
        }else{
            Toast.makeText(this,"Permission Already Granted",Toast.LENGTH_SHORT).show();
        }
    }
}








