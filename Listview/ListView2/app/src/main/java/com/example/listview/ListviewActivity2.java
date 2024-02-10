package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;


import com.example.listview.Adpter.ProgramAdpter;

public class ListviewActivity2 extends AppCompatActivity {
    ListView l;
    String[] name = {"CHiRSH JERICO", "  vishwas mehta","hiru katirya", "ashishbhai mehta", "jagrutiben mehta", "priyanakaben mehta", "mansi mehta","CHiRSH JERICO", "vishwas mehta", "hiru katirya", "ashishbhai mehta", "jagrutiben mehta", "priyanakaben mehta", "mansi mehta", "priyanakaben mehta", "mansi mehta"};
    int[] imgid = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.v, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.v, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a};
    String[] lastmessge = {"hi", "kaya cho", "maja maa ne bhai", "kem che ghare bhadha ne ", "papa avi agaya", "jay Shree Krishna", "hi", "kaya cho", "maja maa ne bhai", "kem che ghare bhadha ne ", "papa avi agaya", "jay Shree Krishna", "hi", "kaya cho", "maja maa ne bhai", "kem che ghare bhadha ne ", "papa avi agaya", "jay Shree Krishna"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);

        l = findViewById(R.id.Listview);

        ProgramAdpter programAdpter = new ProgramAdpter(this, name,imgid,lastmessge);
        l.setAdapter(programAdpter);


    }
}