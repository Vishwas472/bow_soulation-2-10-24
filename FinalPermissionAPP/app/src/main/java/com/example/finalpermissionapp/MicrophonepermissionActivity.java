package com.example.finalpermissionapp;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.RECORD_AUDIO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MicrophonepermissionActivity extends AppCompatActivity {

    Button btn;

    private static final int REQ_CODE_LOCATION = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microphonepermission);
        btn = findViewById(R.id.btnMIcro);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cheackpermission()) {



                    Toast.makeText(MicrophonepermissionActivity.this, "PERMISSION ALREADY GRANTED !", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(MicrophonepermissionActivity.this, new String[]{RECORD_AUDIO}, REQ_CODE_LOCATION);
                }


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_CODE_LOCATION){

            if (grantResults.length > 0){
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

        int resultlocation = ActivityCompat.checkSelfPermission(this, RECORD_AUDIO);

        return resultlocation == PackageManager.PERMISSION_GRANTED ;
    }


}