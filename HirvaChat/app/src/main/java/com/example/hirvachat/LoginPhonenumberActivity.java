package com.example.hirvachat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class LoginPhonenumberActivity extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText Phoneinput;
    Button sendotpbtm;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phonenumber);

        countryCodePicker = findViewById(R.id.login_contrycode);
        Phoneinput = findViewById(R.id.login_mobilenumber);
        sendotpbtm = findViewById(R.id.send_otp_btn);
        progressBar = findViewById(R.id.login_progressbar);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(Phoneinput);
        sendotpbtm.setOnClickListener((v) -> {
            if (!countryCodePicker.isValidFullNumber()){
                Phoneinput.setError("PHONE NUMBER NOT VAILD");
                return;
            }
            Intent intent = new Intent(LoginPhonenumberActivity.this,LoginOtpActivity.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);

        });


    }
}