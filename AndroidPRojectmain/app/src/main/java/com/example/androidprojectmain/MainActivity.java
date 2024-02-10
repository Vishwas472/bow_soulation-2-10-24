package com.example.androidprojectmain;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);


        Toast.makeText(this, "Activity created", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "OnStart method called", Toast.LENGTH_SHORT).show();


        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();


        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent send = new Intent(MainActivity.this, LifecyCelActivity.class);
//Starts TargetActivity
                                       startActivity(send);
                                       Toast.makeText(MainActivity.this, "On pause", Toast.LENGTH_SHORT).show();
                                   }
                               }



        );
        onDestroy();{
            Toast.makeText(this, "onDestory", Toast.LENGTH_SHORT).show();
        }
    }
}