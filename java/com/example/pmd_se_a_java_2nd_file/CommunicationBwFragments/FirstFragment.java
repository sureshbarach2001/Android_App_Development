package com.example.pmd_se_a_java_2nd_file.CommunicationBwFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pmd_se_a_java_2nd_file.R;

public class FirstFragment extends Fragment {
    ButtonPressListener.OnButtonPressListener buttonPressListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.firstfragment,container,false);
        myFunction(root);
        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListener = (ButtonPressListener.OnButtonPressListener) getActivity();
    }

    void myFunction(ViewGroup root)
    {
        TextView textView = root.findViewById(R.id.txtcmfragment);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                textView.setText("Message aya ha First Fragment se...");
                buttonPressListener.onButtonPressed("Message aya ha First Fragment se...");
            }
        });
    }
}
