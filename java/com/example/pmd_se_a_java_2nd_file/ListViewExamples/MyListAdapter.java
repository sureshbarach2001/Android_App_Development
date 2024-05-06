//package com.example.pmd_se_a_java_2nd_file.ListViewExamples;
//
//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.pmd_se_a_java_2nd_file.R;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class MyListAdapter extends BaseAdapter {
//    public ArrayList<HashMap<String,String>> list;
//    Activity activity;
//
//    public MyListAdapter(ArrayList<HashMap<String, String>> list, Activity activity) {
//        this.list = list;
//        this.activity = activity;
//    }
//
//    public static final String First_Column = "First";
//    public static final String Second_Column = "Second";
//    public static final String Third_Column = "Third";
//    public static final String Fourth_Column = "Fourth";
//
//
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        ViewHolder viewHolder = new ViewHolder();
//        LayoutInflater inflater = activity.getLayoutInflater();
//        if(view == null)
//        {
//            view = inflater.inflate(R.layout.multicolumn,null);
//            viewHolder.textView1 = view.findViewById(R.id.textview1);
//            viewHolder.textView2 = view.findViewById(R.id.textView2);
//            viewHolder.textView3 = view.findViewById(R.id.textView3);
//            viewHolder.textView4 = view.findViewById(R.id.textView4);
//            view.setTag(viewHolder);
//        }
//        else {
//            viewHolder = (ViewHolder) view.getTag();
//        }
//
//        HashMap<String,String> hashMap = list.get(position);
//        viewHolder.textView1.setText(hashMap.get(First_Column));
//        viewHolder.textView2.setText(hashMap.get(Second_Column));
//        viewHolder.textView3.setText(hashMap.get(Third_Column));
//        viewHolder.textView4.setText(hashMap.get(Fourth_Column));
//
//        return view;
//    }
//
//    public class ViewHolder{
//        TextView textView1,textView2,textView3,textView4;
//    }
//
//}
//
