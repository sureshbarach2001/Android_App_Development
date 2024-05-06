package com.example.pmd_se_a_java_2nd_file.SQLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;
import java.util.ArrayList;


public class DbTools extends SQLiteOpenHelper {

    public DbTools(Context context) {
        super(context,"ContactsDB",null,1);
        Log.d("TAG","Database Created");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createQuery = "CREATE TABLE CONTACTS("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "firstName TEXT,"+
                "secondName TEXT,"+
                "phoneNumber TEXT,"+
                "emailAddress TEXT,"+
                "homeAddress TEXT)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void AddContact(HashMap<String,String> contact)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));

        long i = db.insert("CONTACTS",null, contentValues);
        if(i!=-1) {
            Log.d("TAG","New Contact Inserted with _id "+i);
        }
        else {
            Log.d("TAG","New Contact Insertion is Failed");
        }
        db.close();
    }


    public void DeleteContact(String id) {

        SQLiteDatabase db = getWritableDatabase();

        int intID = Integer.parseInt(id);

        int i = db.delete("CONTACTS", "_id="+intID, null);

        if (i != -1) {
            Log.d("TAG", "Contact is deleted successfully with _id " + id);
        }
        else {
            Log.d("TAG", "No contact was deleted with _id " + id);
        }
        db.close();
    }



    public void UpdateContact(HashMap<String,String> contact, String id) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));

        long i = db.update("CONTACTS", contentValues, "_id = ?", new String[]{id});

        if( i!=-1 ) {
            Log.d("TAG","Contact is Updated Successfully with _id: "+ i);
        }
        else {
            Log.d("TAG","Contact Updation is Failed for _id: " + i);
        }
        db.close();
    }



    public ArrayList<HashMap<String, String>> getAllContacts() {

        int i = 1;
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        String Query = "SELECT * FROM CONTACTS";
        Cursor cursor = db.rawQuery(Query, null);

        if ( cursor.moveToFirst() ) { // Checking First Row of Data
            do {
                HashMap<String, String> contact = new HashMap<>();

                contact.put("no.", i + "");
                contact.put("_id", cursor.getString(0));
                contact.put("firstName", cursor.getString(1));
                contact.put("secondName", cursor.getString(2));
                contact.put("phoneNumber", cursor.getString(3));
                contact.put("emailAddress", cursor.getString(4));
                contact.put("homeAddress", cursor.getString(5));
                contactList.add(contact);
                i++;

            } while ( cursor.moveToNext() );
        }

        return contactList;
    }


    public HashMap<String, String> getSingleContact(String id) {

        SQLiteDatabase db = getReadableDatabase();
        HashMap<String, String> singleContact = new HashMap<String, String>();

        String Query = "SELECT * FROM CONTACTS WHERE _id = " + id;
        Cursor cursor = db.rawQuery(Query, null);

        if ( cursor.moveToFirst() ) {
            singleContact.put("_id", cursor.getString(0));
            singleContact.put("firstName", cursor.getString(1));
            singleContact.put("secondName", cursor.getString(2));
            singleContact.put("phoneNumber", cursor.getString(3));
            singleContact.put("emailAddress", cursor.getString(4));
            singleContact.put("homeAddress", cursor.getString(5));
        }

        return singleContact;
    }


    public String getSpecificContactID(String id) {

        ArrayList<HashMap<String, String>> contacts = getAllContacts();

        for ( HashMap<String, String> contact : contacts ) {

            if ( contact.get("no.").equals(id) ) {
                return contact.get("_id");
            }
        }
        return null;
    }
}
