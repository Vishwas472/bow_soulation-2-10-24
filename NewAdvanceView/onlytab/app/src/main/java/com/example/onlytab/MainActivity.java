package com.example.onlytab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // Add a tab with your fragment
        TabLayout.Tab tab = tabLayout.newTab();
        tab.setText("Chats");
        tabLayout.addTab(tab);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.Conatiner, new BlankFragment())
                .commit();
    }
}