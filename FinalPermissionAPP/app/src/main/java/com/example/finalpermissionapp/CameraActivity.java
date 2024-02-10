package com.example.finalpermissionapp;

import static android.Manifest.permission.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {
    ImageView imageView;
    Button btn;

    private static final int pic_id = 123;
    Button camera_open_id;
    ImageView click_image_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {
        camera_open_id = findViewById(R.id.camera_button);
        click_image_id = findViewById(R.id.click_image);


        camera_open_id.setOnClickListener(v -> {
            if (Cheackpermission()) {

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
                Toast.makeText(CameraActivity.this, "PERMISSION ALREADY GRANTED !", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(CameraActivity.this, new String[]{CAMERA}, pic_id);
            }


        });


    }

    private boolean Cheackpermission() {
        int resultlocation = ActivityCompat.checkSelfPermission(this, CAMERA);

        return resultlocation == PackageManager.PERMISSION_GRANTED;

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            click_image_id.setImageBitmap(photo);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == pic_id) {

            if (grantResults.length > 0) {
                int loc = grantResults[0];
                boolean cheackloc = loc == PackageManager.PERMISSION_GRANTED;

                if (cheackloc) {
                    Toast.makeText(this, "PERMSSION_GRANTED", Toast.LENGTH_SHORT).show();

                    Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(camera_intent, pic_id);

                } else {
                    Toast.makeText(this, "PERMISSION DENIED !", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}