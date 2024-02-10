package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Custom_progressbarActivity extends AppCompatActivity {
    Button button;
    Dialog dialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progressbar);

        button=findViewById(R.id.btnA);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(Custom_progressbarActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dilog_box);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                new CountDownTimer(5000, 1000) {

                    @Override
                    public void onTick(long l)
                    {
                    }
                    @Override
                    public void onFinish()
                    {
                        dialog.dismiss();
                    }
                }.start();
            }
        });
    }




}