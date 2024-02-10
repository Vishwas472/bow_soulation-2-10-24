package com.example.android20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class AppbarLayoutActvity extends AppCompatActivity {
    Toolbar tt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_layout_actvity);
        tt= findViewById(R.id.toolbar);
        setSupportActionBar(tt);
    }
}