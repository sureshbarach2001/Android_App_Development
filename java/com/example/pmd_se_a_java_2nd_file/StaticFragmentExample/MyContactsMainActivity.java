package com.example.pmd_se_a_java_2nd_file.StaticFragmentExample;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pmd_se_a_java_2nd_file.R;

public class MyContactsMainActivity extends AppCompatActivity implements Contacts.ListSelectionListener {

    public static String[] contactsArray;
    public static String[] contactDetails;
    public ContactDetails contactDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts_main);
//        contactDetails = getResources().getStringArray(R.array.contacts_array);
//        contactDetails = getResources().getStringArray(R.array.details_array);
        contactDetailsFragment = (ContactDetails) getSupportFragmentManager().findFragmentById(R.id.contactdetails);
    }

    @Override
    public void onSelection(int position) {
        if(contactDetailsFragment.getShownIndex() != position)
        {
            contactDetailsFragment.ContactIndex(position);
        }
    }
}