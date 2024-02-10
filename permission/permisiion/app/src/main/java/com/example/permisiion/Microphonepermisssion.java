package com.example.permisiion;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.FOREGROUND_SERVICE_MICROPHONE;
import static android.Manifest.permission.RECORD_AUDIO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class Microphonepermisssion extends AppCompatActivity {
    Button  btn234;
    private static final int REQ_CODE_LOCATION = 200;
    MediaRecorder mediaRecorder ;
    MediaPlayer mediaPlayer ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microphonepermisssion);
        btn234 =findViewById(R.id.btnMicrophone);

        btn234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cheackpermission()) {

                    Toast.makeText(Microphonepermisssion.this, "PERMISSION ALREADY GRANTED !", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(Microphonepermisssion.this, new String[]{RECORD_AUDIO}, REQ_CODE_LOCATION);
                }


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_CODE_LOCATION){

            if (grantResults.length > 0){
                int loc = grantResults[0];
                boolean cheackloc = loc == PackageManager.PERMISSION_GRANTED;

                if (cheackloc){
                    Toast.makeText(this, "PERMSSION_GRANTED", Toast.LENGTH_SHORT).show();




                }
                else {
                    Toast.makeText(this, "PERMISSION DENIED !", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    public boolean Cheackpermission() {

        int resultlocation = ActivityCompat.checkSelfPermission(this, RECORD_AUDIO);

        return resultlocation == PackageManager.PERMISSION_GRANTED ;
    }

    public  void play(View v){
        try {

            mediaPlayer.setDataSource( getRecordingFilePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setDataSource(getRecordingFilePath());
        }catch (Exception e )
        {
            e.printStackTrace();
        }


    }
    public  void Stoprecording(View v)

    {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        Toast.makeText(this, "Recording is Stop", Toast.LENGTH_SHORT).show();
    }

    public void btnrecord(View v)
    {
        try {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(getRecordingFilePath());
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();
            Toast.makeText(this, "Recording Is Satarted ", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    private String getRecordingFilePath(){
        ContextWrapper contextWrapper =  new ContextWrapper(getApplicationContext());
        File musicDirectory =  contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file  = new File(musicDirectory,"testRecordingFile"+".mp3");
        return file.getPath();
    }
}