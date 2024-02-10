package com.example.athorview.Location;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.athorview.R;
import com.google.android.material.textfield.TextInputEditText;

public class Distance2Activity extends AppCompatActivity {
    private TextInputEditText sorceedit, Distinactionedit;
    private Button drawbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance2);
        drawbtn = findViewById(R.id.btnShow);
        sorceedit = findViewById(R.id.edtsorc);
        Distinactionedit = findViewById(R.id.edtDist);

        drawbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String src = sorceedit.getText().toString().trim();
                String des = Distinactionedit.getText().toString().trim();
                if (src.isEmpty() || des.isEmpty()) {
                    Toast.makeText(Distance2Activity.this, "Please enter Source and Destiny Location", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + src + "/" + des);
                        Intent i = new Intent(Intent.ACTION_VIEW, uri);
                        i.setPackage("com.google.android.apps.maps");
                        startActivity(i);
                    }catch (ActivityNotFoundException e)
                    {
                        e.printStackTrace();
                        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                        Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                        startActivity(intent);
                    }

                }
            }
        });
    }
}