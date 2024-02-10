package com.codewithcoffee.gallerydemo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FinalActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        findViewById(R.id.permisiion).setOnClickListener(view -> {
            mypermission();

        });
    }

    private final ActivityResultLauncher<String[]> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), permission -> {
        boolean allGranted = true;
        for (Boolean isGranted : permission.values()) {
            if (!isGranted) {
                allGranted = false;
                break;
            }
        }
        if (allGranted) {
            Toast.makeText(this, "ALL PERMISSION IS GRATED", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ASOME PERMISSION IS DENIED !!!", Toast.LENGTH_SHORT).show();
        }
    });

    private void mypermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            String[] permission = new String[]{
                    android.Manifest.permission.READ_MEDIA_VIDEO,
                    android.Manifest.permission.READ_MEDIA_IMAGES,
                    android.Manifest.permission.READ_MEDIA_AUDIO,
                    android.Manifest.permission.CAMERA,


            };
            List<String> permissiononstoRequest = new ArrayList<>();
            for (String permissions : permission) {
                if (ContextCompat.checkSelfPermission(this, permissions) != PackageManager.PERMISSION_GRANTED) {
                    permissiononstoRequest.add(permissions);
                }
            }

            if (permissiononstoRequest.isEmpty()) {
                Toast.makeText(this, "All permisiions  ready Granted ", Toast.LENGTH_SHORT).show();
            } else {
                String[] permissionsArray = permissiononstoRequest.toArray(new String[0]);
                boolean shouldshowRationals = false;

                for (String permission23 : permissionsArray) {
                    if (shouldShowRequestPermissionRationale(permission23)) {
                        shouldshowRationals = true;
                        break;
                    }
                }
                if (shouldshowRationals) {
                    new AlertDialog.Builder(this)
                            .setMessage("please allow  all permission")
                            .setCancelable(false)
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    activityResultLauncher.launch(permissionsArray);

                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Toast.makeText(FinalActivity.this, "Please Click On Yes And Allow Allow All Permission To Access All Files", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                } else {
                    activityResultLauncher.launch(permissionsArray);
                }
            }


        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                Toast.makeText(this, "ALready Granted", Toast.LENGTH_SHORT).show();
            } else{
                try {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s", getApplicationContext().getPackageName())));
                    startActivityIfNeeded(intent, 101);
                    Toast.makeText(this, "Give Permission To access All Files ", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    startActivityIfNeeded(intent, 101);

                }
            }

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkAndRequestPermissions();

        }
    }

    private void checkAndRequestPermissions() {
        String[] permissions = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            // Permissions are already granted
            //
            Toast.makeText(this, "Permission Are Already Granted ", Toast.LENGTH_SHORT).show();
        } else {

            ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {

            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Is Granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Please Allow The Permission", Toast.LENGTH_SHORT).show();

            }
        }
    }
}