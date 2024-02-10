package com.example.android20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class CustomToolbarActivity extends AppCompatActivity {
    Toolbar tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toolbar);

        tt=findViewById(R.id.toolbar);
        setSupportActionBar(tt);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//for back button

        getSupportActionBar().setTitle("MY TOOOLBAR");
        getSupportActionBar().setSubtitle("Thats Sub TItile");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.tollbarmenu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();

        if(itemid == R.id.Demo){
            Toast.makeText(this, "Demo", Toast.LENGTH_SHORT).show();
        } else if (itemid == R.id.setting) {

            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
        } else if (itemid == android.R.id.home) {
                super.getSupportActionBar();
            Toast.makeText(this, "OnBackPress", Toast.LENGTH_SHORT).show();

        }
        else if (itemid == R.id.open_save){
            Toast.makeText(this, "open ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Gand Marvo", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}