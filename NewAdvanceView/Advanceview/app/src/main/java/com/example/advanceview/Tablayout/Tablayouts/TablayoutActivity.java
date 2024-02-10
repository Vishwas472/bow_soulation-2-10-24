package com.example.advanceview.Tablayout.Tablayouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.advanceview.R;
import com.google.android.material.tabs.TabLayout;

public class TablayoutActivity extends AppCompatActivity
        implements OnButtonClickListener
{
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        tabLayout = findViewById(R.id.TAB);
        viewPager = findViewById(R.id.VIEWPAGER);
        tt = findViewById(R.id.toolbar);
        setSupportActionBar(tt);




        getWindow().setStatusBarColor(ContextCompat.getColor(TablayoutActivity.this,R.color.darkdgreen));


        getSupportActionBar().setTitle("WhatsApp");
        tt.setTitleTextColor(Color.WHITE);


        ViewpagerMessagerAdpter adpter = new ViewpagerMessagerAdpter(getSupportFragmentManager());
        viewPager.setAdapter(adpter);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.VIEWPAGER, new ChatFragment())
                    .commit();
        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == R.id.New_groups) {

            Toast.makeText(this, "New_groups", Toast.LENGTH_SHORT).show();
        } else if (itemid == R.id.Broad_Caste) {

            Toast.makeText(this, "Broad Caste Message ", Toast.LENGTH_SHORT).show();
        } else if (itemid == R.id.Linked_messge) {

            Toast.makeText(this, "Linked Message", Toast.LENGTH_SHORT).show();
        } else if (itemid == R.id.Stragged_Message) {

            Toast.makeText(this, "Stragged Message", Toast.LENGTH_SHORT).show();
        } else if (itemid == R.id.Payment) {

            Toast.makeText(this, "Payment", Toast.LENGTH_SHORT).show();
        } else if (itemid == R.id.Setting) {

            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);


    }

    @Override
    public void onButtonClicked(View view) {
        if (view.getId()==R.id.li11111){
            Toast.makeText(this, "Chat Fragment", Toast.LENGTH_SHORT).show();

        } else if (view.getId() == R.id.l222) {
            Toast.makeText(this, "Stauts Fragment", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.calss) {

            Toast.makeText(this, "Calls Fragment", Toast.LENGTH_SHORT).show();

        }
    }
}