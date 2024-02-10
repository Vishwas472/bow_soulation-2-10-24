package com.example.myapplication.TimepickerDilogboX;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.myapplication.R;

public class TimePicker2Activity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker2);

        Button button =  findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timepicker = new TimepickerFragment();
                timepicker.show(getSupportFragmentManager(),"TIME PICKER");

               }
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

        TextView textView = findViewById(R.id.txttime);

        textView.setText("HOUR :"+i+"  Minutes :"+i1);

    }
}