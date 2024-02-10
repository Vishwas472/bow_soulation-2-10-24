package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView txtname,TxtAdrres,Dateofbirth;
    TextView caLL,EMAIL,usernam3e;


    StringBuilder str;


    StudentModel student = new StudentModel();
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        StringBuilder str=new StringBuilder();

        txtname=findViewById(R.id.txtname);


        for (int i = 0; i < MainActivity.list.size(); i++) {

            student = MainActivity.list.get(i);
            String FullName = student.getFullname();
            String fullAdrees = student.getFullAdreess();
            String Phonenumber = student.getNumber();
            String email = student.getEmail();
            String Dateofbirth = String.valueOf(student.getDate());
            String username = student.getUsername();

            str.append("Full Name = ").append(FullName).append("\n");
            str.append("Full Adrees = ").append(fullAdrees).append("\n");
            str.append("Call= ").append(Phonenumber).append("\n");
            str.append("Email = ").append(email).append("\n");
            str.append("Date of Birth = ").append(Dateofbirth).append("\n");
            str.append("User name = ").append(username).append("\n");




        }
        txtname.setText(str);







    }
}