package com.example.spinner.RecyclerView2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spinner.R;

import java.util.ArrayList;

public class Adpter extends RecyclerView.Adapter<Adpter.Viewholder> {
    Context context;
    ArrayList<Demo> arr;

    public Adpter(Context context, ArrayList<Demo> arr) {
        this.context = context;
        this.arr = arr;


    }

    @NonNull
    @Override
    public Adpter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vs = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_file, parent, false);
        Viewholder v = new Viewholder(vs);


        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull Adpter.Viewholder holder, int position) {
        holder.txtname.setText(arr.get(position).Data);
        holder.ig.setImageResource(arr.get(position).img);

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txtname;
        ImageView ig;

        public Viewholder(View vs) {


            super(vs);
            txtname=vs.findViewById(R.id.textCategories);
            ig=vs.findViewById(R.id.imag123);


        }
    }
}
