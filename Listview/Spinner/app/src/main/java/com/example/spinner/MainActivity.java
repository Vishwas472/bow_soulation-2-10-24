package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Countryitem> mCountryList;
    private  ContryAdpter mAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initlist();

        Spinner spinnercountries = findViewById(R.id.spinner_countries);
        mAdpter = new ContryAdpter(this,mCountryList);
        spinnercountries.setAdapter(mAdpter);



        spinnercountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 Countryitem clickeditem = (Countryitem) adapterView.getItemAtPosition(i);
                 String ClickedContryName  = clickeditem.getmContryname();
                Toast.makeText(MainActivity.this, "Selected"+ClickedContryName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initlist() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new Countryitem("india",R.drawable.b));
        mCountryList.add(new Countryitem("China",R.drawable.a));
        mCountryList.add(new Countryitem("Rusia",R.drawable.c));
        mCountryList.add(new Countryitem("South Africa",R.drawable.d));
        mCountryList.add(new Countryitem("Japan",R.drawable.e));

    }
}
