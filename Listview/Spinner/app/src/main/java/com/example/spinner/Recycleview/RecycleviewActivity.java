package com.example.spinner.Recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.spinner.R;

import java.util.ArrayList;

public class RecycleviewActivity extends AppCompatActivity {

    RecyclerView rcv;
    ArrayList<model> Caategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        initview();

    }

    private void initview() {
        rcv = findViewById(R.id.rcv);

        model m1 = new model();
        m1.setName("Mother");
        m1.setImage(R.drawable.e);
        Caategories.add(m1);

        model m12 = new model();
        m12.setName("Father");
        m12.setImage(R.drawable.e);
        Caategories.add(m12);

        model m11 = new model();
        m11.setName("Sister");
        m11.setImage(R.drawable.e);
        Caategories.add(m11);

        model m2 = new model();
        m2.setName("Sad");
        m2.setImage(R.drawable.e);
        Caategories.add(m2);

        model m3 = new model();
        m3.setName("Angry");
        m3.setImage(R.drawable.e);
        Caategories.add(m3);

        model m4 = new model();
        m4.setName("Love");
        m4.setImage(R.drawable.e);
        Caategories.add(m4);

        model m5 = new model();
        m5.setName("Car");
        m5.setImage(R.drawable.e);
        Caategories.add(m5);

        model m6 = new model();
        m6.setName("Enjoy");
        m6.setImage(R.drawable.e);
        Caategories.add(m6);

        model m7 = new model();
        m7.setName("Friends");
        m7.setImage(R.drawable.e);
        Caategories.add(m7);

        model m8 = new model();
        m8.setName("Happy");
        m8.setImage(R.drawable.e);
        Caategories.add(m8);

        model m9 = new model();
        m9.setName("beard");
        m9.setImage(R.drawable.e);
        Caategories.add(m9);

        model m10 = new model();
        m10.setName("Attitude");
        m10.setImage(R.drawable.e);
        Caategories.add(m10);

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
//        rcv.setLayoutManager(staggeredGridLayoutManager);
        Rcycleviewadpter adpter = new Rcycleviewadpter(RecycleviewActivity.this, Caategories);
        rcv.setAdapter(adpter);
        GridLayoutManager manager = new GridLayoutManager(RecycleviewActivity.this, 2);
        rcv.setLayoutManager(manager);
    }


}