package com.example.android20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FrameLayoutActivity extends AppCompatActivity {

    TextView textView44,textView55;
    Button btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        textView44 = findViewById(R.id.textView4);
        textView55 = findViewById(R.id.textView5);
        btn1 = findViewById(R.id.btn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView44.getVisibility() == View.VISIBLE){
                    textView44.setVisibility(View.GONE);
                    textView55.setVisibility(View.VISIBLE);


                }else {
                    textView44.setVisibility(View.VISIBLE);
                    textView55.setVisibility(View.GONE);
                }
            }
        });

    }
}