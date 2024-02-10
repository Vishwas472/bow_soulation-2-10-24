package com.example.androidprojectmain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContenetProviderActivity extends AppCompatActivity {

    ListView listView;
    Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenet_provider);

        listView = findViewById(R.id.listview1);
        Button = findViewById(R.id.Contec2t);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewcontenct();
                Toast.makeText(ContenetProviderActivity.this, "click the buttton", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Data() {

    }

    private void viewcontenct() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);

        } else {
            ArrayList<String> Contect = new ArrayList<>();
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(uri, null, null, null, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String Contentname = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String Contectnumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Contect.add(Contentname + "\n" + Contectnumber);

                    listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Contect));
                }
            }
        }
    }
}