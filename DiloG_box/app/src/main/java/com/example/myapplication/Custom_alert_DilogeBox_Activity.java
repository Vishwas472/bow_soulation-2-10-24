package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Custom_alert_DilogeBox_Activity extends AppCompatActivity {
    Button mDialogButton, btnc, btnl;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert_diloge_box);
        mDialogButton = findViewById(R.id.Logoutbb);
        btnc = findViewById(R.id.btncnacel);
        btnl = findViewById(R.id.Logout);

        Dialog dialog = new Dialog(Custom_alert_DilogeBox_Activity.this);

        mDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setContentView(R.layout.custom_diloge_box);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                btnc = dialog.findViewById(R.id.btncnacel);
                btnl = dialog.findViewById(R.id.Logout);

                btnc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(Custom_alert_DilogeBox_Activity.this, " Cancel", Toast.LENGTH_SHORT).show();

                    }
                });

                btnl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(Custom_alert_DilogeBox_Activity.this, "You Have Logout Succesfully", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();

            }
        });


    }
}