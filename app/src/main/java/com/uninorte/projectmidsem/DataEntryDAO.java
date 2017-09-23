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
        values.put(DatabaseHandler.KEY_FIELD_STDNAME, entry.field1);
        values.put(DatabaseHandler.KEY_FIELD_STDCODE, entry.field2);
        values.put(DatabaseHandler.KEY_FIELD_STDSEM, entry.field3);
        values.put(DatabaseHandler.KEY_FIELD_STDMAIL, entry.field4);

        Long index = mDatabase.insert(DatabaseHandler.TABLE_STD,null,values);

        return index;
    }


    // Getting All Entries
    public List<DataEntry> getAllEntries(String table_name) {
        Log.d(TAG, "getAllEntries ");

        List<DataEntry> entryList = new ArrayList<>();

        // select All Querry
        String selectQuery = "SELECT * FROM " + table_name;

        Cursor cursor = mDatabase.rawQuery(selectQuery, null);

        // Looping through all rows and adding to List
        switch (table_name) {
            case DatabaseHandler.TABLE:
                if (cursor.moveToFirst()) {
                    do {
                        DataEntry entry = new DataEntry();
                        entry.id = Integer.parseInt(cursor.getString(0));
                        entry.field1 = cursor.getString(1);
                        entryList.add(entry);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                break;
            case DatabaseHandler.TABLE_STD:
                if (cursor.moveToFirst()) {
                    do {
                        DataEntryStd entry = new DataEntryStd();
                        entry.idSubj = Integer.parseInt(cursor.getString(0));
                        entry.field1 = cursor.getString(1);
                        entry.field2 = cursor.getString(2);
                        entry.field3 = cursor.getString(3);
                        entry.field4 = cursor.getString(4);
                        entryList.add(entry);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                break;
        }
//        if (cursor.moveToFirst()) {
//            do {
//                DataEntry entry = new DataEntry();
//                entry.id = Integer.parseInt(cursor.getString(0));
//                entry.field1 = cursor.getString(1);
//                entryList.add(entry);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//
        // return entry list
        return entryList;
    }

    // Getting entry count
    public int getEntryCount(String table_name) {
        int count;
        Log.d(TAG, "getEntryCount ");

        String countQuery = "SELECT * FROM " + table_name;

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

    public void deleteEntryStd(DataEntryStd entry) {
        mDatabase.delete(DatabaseHandler.TABLE_STD, DatabaseHandler.KEY_ID_STD + " = ?",
                new String[] { String.valueOf(entry.idSubj) }
        );
    }

    //

}
