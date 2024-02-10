package com.example.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContryAdpter extends ArrayAdapter<Countryitem> {

    public ContryAdpter(Context context, ArrayList<Countryitem> contrylist){
        super(context,0,contrylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initview(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initview(position,convertView,parent);
    }

    private View initview(int position,  View convertView,  ViewGroup parent){
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.demo_spinener_item_file,parent,false);
        }
        ImageView  imageviewflag = convertView.findViewById(R.id.image_view_flag);
        TextView  textviewName = convertView.findViewById(R.id.text_view_name);

        Countryitem currentItem = getItem(position);

        if (currentItem != null) {
            imageviewflag.setImageResource(currentItem.getmFlagImage());
            textviewName.setText(currentItem.getmContryname());
        }
        return  convertView;


    }

}
