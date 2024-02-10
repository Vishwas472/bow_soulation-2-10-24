package com.example.athorview.Gallray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.athorview.R;

public class urllimageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urllimage);

        ImageView imageView = findViewById(R.id.imageViewsdt);

        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxTTldLMkOtxGHoWI8Q80F__IupBxtHSCE8Q&usqp=CAU").into(imageView);
    }
}