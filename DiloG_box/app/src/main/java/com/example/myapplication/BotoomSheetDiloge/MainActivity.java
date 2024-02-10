package com.example.myapplication.BotoomSheetDiloge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        btn=findViewById(R.id.btnbottom);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDiloge();
            }
        });
    }

    private void showDiloge() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.botoom_sheet_layout);

        LinearLayout  editlayout  = dialog.findViewById(R.id.layoutEdit);
        LinearLayout  layoutShare  = dialog.findViewById(R.id.layoutShare);
        LinearLayout  layoutUpload  = dialog.findViewById(R.id.layoutUpload);
        LinearLayout  printlayout  = dialog.findViewById(R.id.layoutPrint);


        editlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Edit is CLicked", Toast.LENGTH_SHORT).show();
            }
        });

        layoutShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "layoutShare is CLicked", Toast.LENGTH_SHORT).show();
            }
        });

        layoutUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "layoutUpload is CLicked", Toast.LENGTH_SHORT).show();
            }
        });

        printlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "printlayout is CLicked", Toast.LENGTH_SHORT).show();
            }
        });


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        //ahiya match parenet and wrap contenet dilog box ni hight  mate che
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations=R.style.DilogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}