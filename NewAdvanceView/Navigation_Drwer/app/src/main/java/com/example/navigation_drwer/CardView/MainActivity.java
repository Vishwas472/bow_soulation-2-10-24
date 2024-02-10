package com.example.navigation_drwer.CardView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.navigation_drwer.R;

public class MainActivity extends AppCompatActivity {

    CardView cardView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cardView = findViewById(R.id.cardView);
        cardView.setRadius(5.0f);
        cardView.setElevation(11.0f);
        cardView.setUseCompatPadding(true);
        cardView.setBackgroundColor(R.color.lavender2);
    }
}