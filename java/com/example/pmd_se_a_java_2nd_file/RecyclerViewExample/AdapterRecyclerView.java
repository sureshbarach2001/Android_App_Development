package com.example.pmd_se_a_java_2nd_file.RecyclerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmd_se_a_java_2nd_file.R;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>
{
    private List<MyMobiles> mobilesList;

    public AdapterRecyclerView(List<MyMobiles> mobilesList) {
        this.mobilesList = mobilesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobilerowexample, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyMobiles myMobiles = mobilesList.get(position);
        holder.mobileName.setText(myMobiles.getName());
        holder.mobileCompany.setText(myMobiles.getCompany());
        holder.mobilePrice.setText(myMobiles.getPrice());
    }
    @Override
    public int getItemCount() {
        return mobilesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mobileName, mobileCompany, mobilePrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mobileName = itemView.findViewById(R.id.txtmobilename);
            mobileCompany = itemView.findViewById(R.id.txtmobilecompany);
            mobilePrice = itemView.findViewById(R.id.txtmobileprice);
        }
    }
}
