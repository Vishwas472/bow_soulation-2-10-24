package com.example.listview.Adpter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.R;

public class ProgramViewholder {

    ImageView imageView;
    TextView name;
    TextView lastmessge;

    ProgramViewholder(View v) {
        imageView = v.findViewById(R.id.image);
        name = v.findViewById(R.id.name);
        lastmessge = v.findViewById(R.id.Discripation);



    }
}
