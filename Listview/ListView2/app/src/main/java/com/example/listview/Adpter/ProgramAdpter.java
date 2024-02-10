package com.example.listview.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview.ListviewActivity2;
import com.example.listview.R;

public class ProgramAdpter extends ArrayAdapter<String> {
    Context context;
    int[] imgid;
    String[] name;
    String[] lastmessge;

    public ProgramAdpter(Context context, String[] name, int[] imgid, String[] lastmessge) {
        super(context, R.layout.list_item, R.id.name, name);
        this.context = context;
        this.imgid = imgid;
        this.name = name;
        this.lastmessge = lastmessge;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View sigleitem = convertView;
        ProgramViewholder holder = null;
        if (sigleitem == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            sigleitem = layoutInflater.inflate(R.layout.list_item, parent, false);
            holder = new ProgramViewholder(sigleitem);
            sigleitem.setTag(holder);
        } else {
            holder = (ProgramViewholder) sigleitem.getTag();

        }
        holder.imageView.setImageResource(imgid[position]);
        holder.name.setText(name[position]);
        holder.lastmessge.setText(lastmessge[position]);


        sigleitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You CLick  "+name[position], Toast.LENGTH_SHORT).show();
            }
        });


        return sigleitem;


    }
}
