package com.example.myapplication.DatePickerDilogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.myapplication.R;

import java.util.Calendar;

public class DatePicker3activity extends AppCompatActivity {

    Button btn;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker3activity);

        btn = findViewById(R.id.TxtDate5);
        edt = findViewById(R.id.edttext);

        final Calendar date = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(DatePicker3activity.this, R.style.CustomDatePickerDialog,new DatePickerDialog.OnDateSetListener() {
//ahiya pan apne theme nee add kari ne diloge box no colour change kari sakiye chea
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                Calendar Update =  Calendar.getInstance();
                Update.set(i,i1,i2);
                i1= i1+1;
                edt.setText("Date :"+i+"/"+i1+"/"+i2);
            }
        },date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH));
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 datePickerDialog.show();
             }
         });

    }
}