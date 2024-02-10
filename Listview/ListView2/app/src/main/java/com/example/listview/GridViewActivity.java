package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.listview.Adpter.GridAdpter;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = findViewById(R.id.GRidView);

        String[] flowerName = {"ROSE", "LOTUS",
                "Daisy", "Lavender",
                "Jasmine",
                "Marigold", "Chrysanthemum","ROSE", "LOTUS",
                "Daisy", "Lavender",
                "Jasmine",
                "Marigold", "Chrysanthemum"};


        int[] Flowerimage = {R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a,R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a};


        GridAdpter gridAdpter = new GridAdpter(GridViewActivity.this,flowerName,Flowerimage);
        gridView.setAdapter(gridAdpter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "You Are Selected "+flowerName, Toast.LENGTH_SHORT).show();
            }
        });

    }
}