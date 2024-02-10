package com.example.matrailui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MatrialEdittextActivity extends AppCompatActivity {
    Button bSubmit;
    EditText mEditText;
    TextView tvTextPreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrial_edittext);

        initview();
    }

    private void initview() {
        bSubmit = findViewById(R.id.submit_button);
        mEditText = findViewById(R.id.edit_text);
        tvTextPreview = findViewById(R.id.text_preview);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // set the entered data to text preview
                tvTextPreview.setText("You Entered : " + mEditText.getText().toString());
            }
        });
    }
}