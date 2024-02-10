package com.example.spinner.Recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spinner.MainActivity;
import com.example.spinner.R;

import java.util.ArrayList;

public class Rcycleviewadpter extends RecyclerView.Adapter<Rcycleviewadpter.Myviewholder> {
    Context context;
    ArrayList<model> caategories;

    public Rcycleviewadpter(Context context, ArrayList<model> caategories) {
        this.context = context;
        this.caategories = caategories;


    }

    public Rcycleviewadpter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_file, parent, false);
        Myviewholder w = new Myviewholder(v);
        return w;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        holder.textCategories.setText(caategories.get(position).getName());
        holder.imag123.setImageResource(caategories.get(position).getImage());

    }

    @Override
    public int getItemCount() {

        return caategories.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        TextView textCategories;

        ImageView imag123;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            textCategories = itemView.findViewById(R.id.textCategories);
            imag123 = itemView.findViewById(R.id.imag123);
        }
    }
}
