package com.example.matrailui.Custom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.matrailui.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatirialEdittextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matirial_edittext);

        TextInputLayout LayoutPassword = findViewById(R.id.layoutpassowrd);
       TextInputEditText eTextpassword = findViewById(R.id.password_edt);

        eTextpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = charSequence.toString();

                if (password.length() >= 8){
                    Pattern pattern = Pattern.compile("[^a-zA-z0-9]");
                    Matcher matcher = pattern.matcher(password);
                    boolean ispwscontainsSpecialChar = matcher.find();
                    if (ispwscontainsSpecialChar){
                        LayoutPassword.setHelperText("Strong Password");
                        LayoutPassword.setError("");
                    }
                    else {
                        LayoutPassword.setHelperText("");
                        LayoutPassword.setError("Weak Password Pleasee enter 1 Special Charcter");
                    }
                }
                else {
                    LayoutPassword.setHelperText("Minimum enter 8  digits");
                    LayoutPassword.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}