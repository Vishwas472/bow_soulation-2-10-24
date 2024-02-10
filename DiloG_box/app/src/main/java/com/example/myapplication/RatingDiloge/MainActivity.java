package com.example.myapplication.RatingDiloge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    AppCompatButton Rating ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Rating=findViewById(R.id.rating);

        Rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RateUsDiloge rateUsDiloge=  new RateUsDiloge(MainActivity.this);
                rateUsDiloge.getWindow().setBackgroundDrawable(new ColorDrawable((getResources().getColor(android.R.color.transparent))));
                rateUsDiloge.setCancelable(false);
                rateUsDiloge.show();
            }
        });




    }
}