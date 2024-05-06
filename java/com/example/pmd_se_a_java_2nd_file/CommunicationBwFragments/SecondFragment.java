package com.example.pmd_se_a_java_2nd_file.CommunicationBwFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pmd_se_a_java_2nd_file.R;

public class SecondFragment extends Fragment {
    TextView textView;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
            view = inflater.inflate(R.layout.firstfragment,container,false);
            return view;
    }
    public void onFragmentInteraction(String message)
    {
        textView = view.findViewById(R.id.txtcmfragment);
        textView.setText(message);
    }
}
