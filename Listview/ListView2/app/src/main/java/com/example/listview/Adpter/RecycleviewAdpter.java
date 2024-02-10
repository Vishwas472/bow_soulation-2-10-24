package com.example.listview.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listview.ContectModel;
import com.example.listview.R;

import java.util.ArrayList;

public class RecycleviewAdpter extends RecyclerView.Adapter<RecycleviewAdpter.Viewholder> {
    Context context;
    ArrayList<ContectModel> arrarrcontect;

    public RecycleviewAdpter(Context context, ArrayList<ContectModel> arrarrcontect) {
        this.context = context;
        this.arrarrcontect =arrarrcontect;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycleview_item_file, parent, false);
        Viewholder viewholder = new Viewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.imgContect.setImageResource(arrarrcontect.get(position).Image);
        holder.txtname.setText(arrarrcontect.get(position).Name);
        holder.txtnumber.setText(arrarrcontect.get(position).ContctNumber);




    }

    @Override
    public int getItemCount() {
        return arrarrcontect.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txtname, txtnumber;
        ImageView imgContect;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.Contect_name);
            txtnumber = itemView.findViewById(R.id.Contect_number);
            imgContect = itemView.findViewById(R.id.iamges);
        }
    }
}
