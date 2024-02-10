package com.example.androidprojectmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity2 extends AppCompatActivity {

    Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        call = findViewById(R.id.pick);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Number = "1234567890";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" +Number));
                if (ActivityCompat.checkSelfPermission(IntentActivity2.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    return;
                }


                startActivity(intent);
            }

        });
    }
}