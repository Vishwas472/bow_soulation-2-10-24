package com.example.myapplication.TimepickerDilogboX;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.R;

public class TimepickerActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker2);


        TimePicker timePicker = findViewById(R.id.timePicker);
        Button showTimeButton = findViewById(R.id.showTimeButton);

        showTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String selectedTime = String.format("%02d:%02d", hour, minute);

                Toast.makeText(TimepickerActivity2.this, "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();
            }
        });
    }
}