package com.example.androidprojectmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class broadcasteReciverActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcaste_reciver);

        initview();
    }

    private void initview() {
        image = findViewById(R.id.image);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();


        if(intent.ACTION_SEND.equals(action)  && type!=null){
            image.setImageURI(intent.getParcelableExtra(intent.EXTRA_STREAM));
        }
    }
}