//package com.example.pmd_se_a_java_2nd_file.RestAPI;
//
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.example.pmd_se_a_java_2nd_file.R;
//
//import java.util.List;
//
//public class MyRestAdapter extends RecyclerView.Adapter<MyRestAdapter.ViewHolder>{
//    public List<MyRestAPIModel> list;
//    public Context context;
//
//    public MyRestAdapter(List<MyRestAPIModel> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater  = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.myrestlayout, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.name.setText(list.get(position).getTitle());
//        holder.content.setText(list.get(position).getBody());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        TextView name, content;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name = itemView.findViewById(R.id.myrestnametxt);
//            content = itemView.findViewById(R.id.myrestcontenttxt);
//        }
//    }
//}
