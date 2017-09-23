package com.uninorte.projectmidsem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataEntryDAO {

    public String TAG = Constants.TAG;
    private Context context;
    private DatabaseHandler mDBHandler;
    private SQLiteDatabase mDatabase;

    public DataEntryDAO (Context context){
        this.context = context;
        mDBHandler = new DatabaseHandler(context);

        open();
    }

    public void open() {
        mDatabase = mDBHandler.getWritableDatabase();
    }

    public void close() {
        mDBHandler.close();
    }

    public long addDataEntry(DataEntry entry) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.KEY_FIELD1, entry.field1);

        Long index = mDatabase.insert(DatabaseHandler.TABLE,null,values);

        return index;
    }

    // Adding database support to students
    public long addDataEntryStd(DataEntryStd entry) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.KEY_FIELD1, entry.field1);
        values.put(DatabaseHandler.KEY_FIELD1, entry.field1);
        values.put(DatabaseHandler.KEY_FIELD1, entry.field1);
        values.put(DatabaseHandler.KEY_FIELD1, entry.field1);

        Long index = mDatabase.insert(DatabaseHandler.TABLE,null,values);

        return index;
    }


    // Getting All Entries
    public List<DataEntry> getAllEntries() {
        Log.d(TAG, "getAllEntries ");

        List<DataEntry> entryList = new ArrayList<DataEntry>();

        // select All Querry
        String selectQuery = "SELECT * FROM " + DatabaseHandler.TABLE;

        Cursor cursor = mDatabase.rawQuery(selectQuery, null);

        // Looping through all rows and adding to List
        if (cursor.moveToFirst()) {
            do {
                DataEntry entry = new DataEntry();
                entry.id = Integer.parseInt(cursor.getString(0));
                entry.field1 = cursor.getString(1);
                entryList.add(entry);
            } while (cursor.moveToNext());
        }

        cursor.close();

        // return entry list
        return entryList;
    }

    // Getting entry count
    public int getEntryCount() {
        int count;
        Log.d(TAG, "getEntryCount ");

        String countQuery = "SELECT * FROM " + DatabaseHandler.TABLE;

        Cursor cursor = mDatabase.rawQuery(countQuery, null);
        count = cursor.getCount();
        cursor.close();

        return count;
    }

    // Deleting single entry
    public void deleteEntry(DataEntry entry) {
        mDatabase.delete(DatabaseHandler.TABLE, DatabaseHandler.KEY_ID + " = ?",
                new String[] { String.valueOf(entry.id) }
        );
    }

    //

}
