package com.example.matrailui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText textName,txtPass;
    AppCompatButton Btn;

    TextView Forget;


    Switch Switcher;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textName=findViewById(R.id.edtname);
        txtPass=findViewById(R.id.pp);
        Btn=findViewById(R.id.btn);
        Forget=findViewById(R.id.txtforget);
        Switcher=findViewById(R.id.myMaterialSwitch);



        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textName == null){
                    Toast.makeText(LoginActivity.this, "Email Adrees is Empety", Toast.LENGTH_SHORT).show();
                }
                else if (txtPass == null){
                    Toast.makeText(LoginActivity.this, "Your Password Is Empty", Toast.LENGTH_SHORT).show();

                } else if (txtPass.length() <= 5) {
                    Toast.makeText(LoginActivity.this, "Please Eneter 6 Digits", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Succesfully Connected", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }
        });





    }
}