package com.example.permisiion;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_SMS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RunTimepermisssionActivity extends AppCompatActivity {
    Button btn;
    private static final int REQ_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_timepermisssion);
        btn = findViewById(R.id.btnrequest);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cheackpermission()) {
                    Toast.makeText(RunTimepermisssionActivity.this, "PERMISSION ALREADY GRANTED !", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(RunTimepermisssionActivity.this, new String[]{ACCESS_FINE_LOCATION, READ_SMS}, REQ_CODE);
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
                int msg = grantResults[1];


                boolean cheackloc = loc == PackageManager.PERMISSION_GRANTED;
                boolean Cheacksms = msg == PackageManager.PERMISSION_GRANTED;


                if (cheackloc && Cheacksms){
                    Toast.makeText(this, "PERMSSION_GRANTED", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(this, "PERMISSION DENIED !", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean Cheackpermission() {
        int resultloc = ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION);
        int resultsms = ActivityCompat.checkSelfPermission(this, READ_SMS);

        return resultloc == PackageManager.PERMISSION_GRANTED && resultsms == PackageManager.PERMISSION_GRANTED;

    }
}