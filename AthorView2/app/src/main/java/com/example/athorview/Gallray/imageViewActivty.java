package com.example.athorview.Gallray;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.athorview.R;


import java.net.URI;

public class imageViewActivty extends AppCompatActivity {
    ImageView img;
    TextView txt;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_activty);
        img = findViewById(R.id.imageView);
        txt = findViewById(R.id.txtDemo);
        button = findViewById(R.id.btnGallary);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
            Uri selectimage = data.getData();
            String[] fillpath = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectimage, fillpath, null, null, null);
            cursor.moveToFirst();
            int coloumindex = cursor.getColumnIndex(fillpath[0]);
            String picturepath = cursor.getString(coloumindex);
            cursor.close();

            img.setImageBitmap(BitmapFactory.decodeFile(picturepath));

            String  filename = picturepath.substring(picturepath.lastIndexOf("/")+1);
            txt.setText(filename);


        }
    }
}