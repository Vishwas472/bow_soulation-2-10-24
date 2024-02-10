package com.example.athorview.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.athorview.R;

import java.io.IOException;

public class AssetsActivity extends AppCompatActivity {
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets2);
        mVideoView = findViewById(R.id.videoView23456);

        MediaController mediaController = new MediaController(this);
        mVideoView.setMediaController(mediaController);
        mVideoView.setVideoPath("content://com.example.lesliecorrea.videoapp/big_buck_bunny.mp4");
        mVideoView.start();
    }
}