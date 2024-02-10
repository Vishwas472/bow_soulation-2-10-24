package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.media.MediaTimestamp;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    private MediaPlayer mp;
    private int mVideoWidth, mVideoHeight;
    private boolean mIsVideoSizeKnown = false;
    private boolean mIsVideoReadyToBePlayed = false;
    private SurfaceView mPreview;
    private ImageView BackButton, PlayVideo;
    TextView VideoName;
    private double finalTime = 0;
    private SurfaceHolder holder;
    private double startTime = 0;
    private Handler myHandler = new Handler();
    private SeekBar seekbar;
    private TextView tx1, tx2;
    public static int oneTimeOnly = 0;

    public Button screen;

    boolean isFullScrren = false ;

    private boolean isPlaying = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFormat(PixelFormat.UNKNOWN);


        mPreview = (SurfaceView) findViewById(R.id.surface);

        seekbar = findViewById(R.id.seekbar33);
        tx1 = (TextView) findViewById(R.id.textView23);
        tx2 = (TextView) findViewById(R.id.textView33);
        BackButton = findViewById(R.id.backpressed);
        screen = findViewById(R.id.screen);


        PlayVideo = findViewById(R.id.playvideo);
        VideoName = findViewById(R.id.videoname);

        holder = mPreview.getHolder();
        holder.setFixedSize(800, 480);
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mp = new MediaPlayer();
        mPreview.setKeepScreenOn(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mp.setOnMediaTimeDiscontinuityListener(new MediaPlayer.OnMediaTimeDiscontinuityListener() {
                @Override
                public void onMediaTimeDiscontinuity(@NonNull MediaPlayer mp, @NonNull MediaTimestamp mts) {
                    Log.d("MediaPlayer", "Media time discontinuity occurred");

                }
            });
            mp.clearOnMediaTimeDiscontinuityListener();
        }
//        After calling this method, the listener will no longer receive notifications for time discontinuities.


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                    mp.setVolume(0.5f, 0.5f);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        PlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                    PlayVideo.setImageResource(R.drawable.baseline_play_circle_24);
                } else {
                    mp.start();
                    PlayVideo.setImageResource(R.drawable.baseline_pause_circle_24);
                }
            }
        });
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFullScrren){
                }
            }
        });
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        mp.setDisplay(holder);
        mp.setLooping(true);
        play();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        resizeVideo();
    }




    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
    private void resizeVideo() {
        if (mVideoWidth > 0 && mVideoHeight > 0) {
            // Get surface dimensions
            int surfaceWidth = mPreview.getWidth();
            int surfaceHeight = mPreview.getHeight();

            // Calculate aspect ratios
            float videoAspectRatio = (float) mVideoWidth / mVideoHeight;
            float surfaceAspectRatio = (float) surfaceWidth / surfaceHeight;

            // Adjust size based on aspect ratios
            ViewGroup.LayoutParams layoutParams = mPreview.getLayoutParams();
            if (videoAspectRatio > surfaceAspectRatio) {
                layoutParams.width = surfaceWidth;
                layoutParams.height = (int) (surfaceWidth / videoAspectRatio);
            } else {
                layoutParams.width = (int) (surfaceHeight * videoAspectRatio);
                layoutParams.height = surfaceHeight;
            }

            // Apply new size
            mPreview.setLayoutParams(layoutParams);
        }
    }
    void play() {
        try {
            AssetFileDescriptor afd = getAssets().openFd("song.mp4");
//            AssetFileDescriptor afd = getAssets().openFd("demo.mp4");
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.prepare();


            finalTime = mp.getDuration();

            startTime = mp.getCurrentPosition();

            if (oneTimeOnly == 0) {
                seekbar.setMax((int) finalTime);
                oneTimeOnly = 1;
            }
            tx2.setText(String.format("%d : %d ", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
            Log.d("finalTime", "play: " + finalTime);
            tx1.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) startTime), TimeUnit.MILLISECONDS.toSeconds((long) startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));

            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(UpdateSongTime, 100);


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.start();
    }


    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mp.getCurrentPosition();
            Log.d("startTime", "run: " + startTime);
            tx1.setText(String.format("%d: %d ", TimeUnit.MILLISECONDS.toMinutes((long) startTime), TimeUnit.MILLISECONDS.toSeconds((long) startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    protected void onPause() {
        super.onPause();
        mp.reset();
        mp.release();
    }


}