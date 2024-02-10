package com.example.spinner.RecyclerView2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.spinner.R;
import com.example.spinner.Recycleview.model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Demo> arr = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.rcv);

        initview();




    }

    private void initview() {
        Demo m1 = new Demo();
        m1.setData("Mother");
        m1.setImg(R.drawable.e);
        arr.add(m1);

        Demo m2 = new Demo();
        m2.setData("HIRU");
        m2.setImg(R.drawable.e);
        arr.add(m2);

        Demo m = new Demo();
        m.setData("Mother");
        m.setImg(R.drawable.e);
        arr.add(m);


        Demo m4 = new Demo();
        m4.setData("Mother");
        m4.setImg(R.drawable.e);
        arr.add(m4);

        Demo m5 = new Demo();
        m5.setData("Mother");
        m5.setImg(R.drawable.e);
        arr.add(m5);

        Demo m6 = new Demo();
        m6.setData("Mother");
        m6.setImg(R.drawable.e);
        arr.add(m6);

        Demo m7 = new Demo();
        m7.setData("Mother");
        m7.setImg(R.drawable.e);
        arr.add(m7);

        Demo m8 = new Demo();
        m8.setData("Mother");
        m8.setImg(R.drawable.e);
        arr.add(m8);

        Demo m9 = new Demo();
        m9.setData("Mother");
        m9.setImg(R.drawable.e);
        arr.add(m9);


        Demo m10 = new Demo();
        m10.setData("Mother");
        m10.setImg(R.drawable.e);
        arr.add(m10);

        Demo m11 = new Demo();
        m11.setData("Mother");
        m11.setImg(R.drawable.e);
        arr.add(m11);


        Adpter adpter = new Adpter(this,arr);
        recyclerView.setAdapter(adpter);
        GridLayoutManager Grid = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(Grid);










    }
}