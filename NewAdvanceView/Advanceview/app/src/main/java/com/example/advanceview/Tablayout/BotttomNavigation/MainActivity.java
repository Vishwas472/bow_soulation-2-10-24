package com.example.advanceview.Tablayout.BotttomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.advanceview.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnview = findViewById(R.id.bnview);


        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.darkdgreen));
        bnview.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    loadfragment(new BlankFragment(), true);


                } else if (id == R.id.serch) {
                    loadfragment(new searchFragment(), false);


                } else if (id == R.id.Reels) {

                    loadfragment(new reels_Fragment(), false);


                } else if (id == R.id.Favoraotes) {
                    loadfragment(new Favouraite_Fragment(), false);


                } else {

                    loadfragment(new Profile_Fragment(), false);
                }
            }
        });

        bnview.setSelectedItemId(R.id.home);
    }

    public void loadfragment(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);

        ft.commit();
    }
}