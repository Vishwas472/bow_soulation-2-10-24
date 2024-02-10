package com.example.matrailui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class toggleActivity extends AppCompatActivity {
    ToggleButton togglebutton;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        @SuppressLint("MissingInflatedId") ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle button is checked
                    // Do something when the button is in the checked state
                    Toast.makeText(toggleActivity.this, "Toggle Button Is On", Toast.LENGTH_SHORT).show();
                } else {
                    // The toggle button is unchecked
                    Toast.makeText(toggleActivity.this, "Toggle Button Is Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void oncustomTOggleClick(View view) {

        Toast.makeText(this, "Custom Toggle", Toast.LENGTH_SHORT).show();
    }
}