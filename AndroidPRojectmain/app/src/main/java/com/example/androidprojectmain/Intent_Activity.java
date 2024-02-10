package com.example.androidprojectmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intent_Activity extends AppCompatActivity {
    Button call, msg, email1, data, callp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        call = findViewById(R.id.Dialcall);
        msg = findViewById(R.id.MSG);
        email1 = findViewById(R.id.email);
        data = findViewById(R.id.view);
        callp = findViewById(R.id.Callgg);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idial = new Intent(Intent.ACTION_DIAL);

                idial.setData(Uri.parse("tel: +917777888899"));
                startActivity(idial);
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imsg = new Intent(Intent.ACTION_SENDTO);
                imsg.setData(Uri.parse("smsto:" + Uri.encode("+918140514107")));
                imsg.putExtra("sms_body", "PlEASE SLOVE THE ISSUSE");
                startActivity(imsg);

            }
        });

        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Imail = new Intent(Intent.ACTION_SEND);
                Imail.setType("message/rfc822");
                Imail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc123@gmail.com", "xys12@gmail.com"});
                Imail.putExtra(Intent.EXTRA_SUBJECT, "Queryies");
                Imail.putExtra(Intent.EXTRA_TEXT, "pleasee work all Are properly");
                startActivity(Intent.createChooser(Imail, "Email via"));

            }
        });


        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.tutlane.com"));
                startActivity(intent);
            }
        });

    }
}