package com.example.athorview.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.athorview.R;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);

        // Set the video path or URL
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;


        // Set the video URI
        Uri videoUri = Uri.parse(videoPath);

        // Set up MediaController
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Set the video URI and start playback
        videoView.setVideoURI(videoUri);
        videoView.start();
    }
}