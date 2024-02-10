package com.example.navigation_drwer.Imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.navigation_drwer.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    MyAdpter myAdpter;

    List<Integer> list = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewPager= findViewById(R.id.viewpager);

        list.add(R.drawable.one);
        list.add(R.drawable.two);
        list.add(R.drawable.three);

        myAdpter = new MyAdpter(list);
        viewPager.setAdapter(myAdpter);

    }
}