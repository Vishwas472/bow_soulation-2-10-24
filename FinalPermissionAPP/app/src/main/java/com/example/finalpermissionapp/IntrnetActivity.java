package com.example.finalpermissionapp;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_SMS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntrnetActivity extends AppCompatActivity {
    Button btn;
    private static final int REQ_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrnet);


        btn = findViewById(R.id.btnintrnet);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cheackpermission()) {
                    Toast.makeText(IntrnetActivity.this, "PERMISSION ALREADY GRANTED !", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(IntrnetActivity.this, new String[]{INTERNET}, REQ_CODE);
                }


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQ_CODE) {
            if (grantResults.length > 0) {
                int loc = grantResults[0];



                boolean cheackloc = loc == PackageManager.PERMISSION_GRANTED;


                if (cheackloc){
                    Toast.makeText(this, "PERMSSION_GRANTED", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(this, "PERMISSION DENIED !", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean Cheackpermission() {
        int resultloc = ActivityCompat.checkSelfPermission(this, INTERNET);

        return resultloc == PackageManager.PERMISSION_GRANTED;

    }
}