package com.example.navigation_drwer.FullDemoViewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.navigation_drwer.R;

public class MainActivity extends AppCompatActivity {
    ViewPager mslideViewpager;
    Button backbtn, nextbtn, skipbtn;
    TextView[] dots;
    ViewPagerAdpter viewPagerAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        backbtn = findViewById(R.id.backbtn);
        nextbtn = findViewById(R.id.nextbtn);
        skipbtn = findViewById(R.id.skipbtn);



        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0) > 0)
                    mslideViewpager.setCurrentItem(getItem(-1), true);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getItem(0) < 3) {
                    mslideViewpager.setCurrentItem(getItem(+1), true);
                } else {
                    Intent i = new Intent(MainActivity.this, MainScrrenActivity.class);
                    startActivity(i);
                    finish();


                }

            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainScrrenActivity.class);
                startActivity(i);
                finish();
            }
        });

        mslideViewpager = (ViewPager) findViewById(R.id.sliderviewpager);
        viewPagerAdpter = new ViewPagerAdpter(this);
        mslideViewpager.setAdapter(viewPagerAdpter);
        mslideViewpager.addOnPageChangeListener(viewlistner);
    }
    ViewPager.OnPageChangeListener viewlistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position > 0) {
                backbtn.setVisibility(View.VISIBLE);
            } else {
                backbtn.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i) {
        return mslideViewpager.getCurrentItem() + i;
    }
}