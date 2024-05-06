package com.example.pmd_se_a_java_2nd_file.CardViewExamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pmd_se_a_java_2nd_file.R;

import org.jetbrains.annotations.NonNls;

import java.util.List;

public class AdapterCardView extends RecyclerView.Adapter<AdapterCardView.MyCardViewHolder> {
    public Context context;

    List<My_Model> list;

    public AdapterCardView(Context context, List<My_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card,parent,false);
        return new MyCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCardViewHolder holder, int position) {
        My_Model myModel = list.get(position);
        holder.title.setText(myModel.getName());
        holder.count.setText(String.valueOf(myModel.getTotal_downloads()));
        Glide.with(context).load(myModel.getThumbnails()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyCardViewHolder extends RecyclerView.ViewHolder {
        TextView title, count;
        ImageView imageView;
        public MyCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgcardview);
            title = itemView.findViewById(R.id.txtcard1);
            count = itemView.findViewById(R.id.txtcard2);
        }
    }
}
