package com.example.androidprojectmain;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LifecyCelActivity extends AppCompatActivity {
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecy_cel);
        btn=findViewById(R.id.btn);


        Toast.makeText(this, "On Stop MEthod", Toast.LENGTH_SHORT).show();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Toast.makeText(LifecyCelActivity.this, "On Restert", Toast.LENGTH_SHORT).show();
            }
        });



    }
}