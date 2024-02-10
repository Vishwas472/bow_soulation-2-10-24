package com.example.myapplication.TimepickerDilogboX;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;

import java.util.Calendar;

public class TimepickerFragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int Hour = c.get(Calendar.HOUR_OF_DAY);
        int Minute = c.get(Calendar.MINUTE);//Ahiya Theme No use karvathi Tame Ena Colour ne change kari sako cho

        return new TimePickerDialog(getActivity(), R.style.TimePickerTheme, (TimePickerDialog.OnTimeSetListener) getActivity(), Hour, Minute, DateFormat.is24HourFormat(getActivity()));
    }
}
