package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.listview.Adpter.RecycleviewAdpter;

import java.util.ArrayList;

public class RecycleviewActivity extends AppCompatActivity {
    ArrayList<ContectModel> arrcontect = new ArrayList<>();
//    ContectModel model = new ContectModel(R.drawable.a, "a", "7069033821");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);


        RecyclerView recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));


        arrcontect.add(new ContectModel(R.drawable.a, "a", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "b", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "c", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "d", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "e", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "f", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "g", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "h", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "j", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "k", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "l", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "m", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "n", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "o", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "p", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "q", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "r", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "s", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "t", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "u", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "v", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "w", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "x", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "y", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "z", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "Hiru", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "Hiru", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "Hiru", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "Hiru", "7069033821"));
        arrcontect.add(new ContectModel(R.drawable.a, "Hiru", "7069033821"));


        RecycleviewAdpter recycleviewAdpter =new RecycleviewAdpter(this,arrcontect);
        recyclerView.setAdapter(recycleviewAdpter);

    }
}