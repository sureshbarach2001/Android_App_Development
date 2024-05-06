package com.example.pmd_se_a_java_2nd_file.StaticFragmentExample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.pmd_se_a_java_2nd_file.R;

public class Contacts extends ListFragment {
    public ListSelectionListener mlistener = null;
    public interface ListSelectionListener{
        public void onSelection(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mlistener = (ListSelectionListener) getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.contacttextview,MyContactsMainActivity.contactsArray));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        getListView().setItemChecked(position,true);
        mlistener.onSelection(position);

    }
}
