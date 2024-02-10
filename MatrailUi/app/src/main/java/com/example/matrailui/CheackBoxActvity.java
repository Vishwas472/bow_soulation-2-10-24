package com.example.matrailui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheackBoxActvity extends AppCompatActivity {
    CheckBox pizza, coffe;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheack_box_actvity);

        pizza = findViewById(R.id.checkbox_cheese);
        coffe = findViewById(R.id.checkbox_meat);

        if (pizza.isChecked()) {
            Toast.makeText(this, "You are selected Pizza", Toast.LENGTH_SHORT).show();
        }
        else if(coffe.isChecked()) {
            Toast.makeText(this, "Meat is cheack ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}