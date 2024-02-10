package com.example.permisiion;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_SMS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Loctionpermisssion extends AppCompatActivity {

    Button btn;

    private static final int REQ_CODE_LOCATION = 200;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loctionpermisssion);
        btn = findViewById(R.id.btnloaction);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cheackpermission()) {

                    Intent i = new Intent(getApplicationContext(), CurrentLocationActivity.class);
                    startActivity(i);

                    Toast.makeText(Loctionpermisssion.this, "PERMISSION ALREADY GRANTED !", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(Loctionpermisssion.this, new String[]{ACCESS_FINE_LOCATION}, REQ_CODE_LOCATION);
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

                    Intent i = new Intent(getApplicationContext(), CurrentLocationActivity.class);
                    startActivity(i);


                }
                else {
                    Toast.makeText(this, "PERMISSION DENIED !", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    public boolean Cheackpermission() {

        int resultlocation = ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION);

        return resultlocation == PackageManager.PERMISSION_GRANTED ;
    }


}