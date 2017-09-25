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
        values.put(DatabaseHandler.KEY_FIELD_SUBJECT, entry.stdfield0);
        values.put(DatabaseHandler.KEY_FIELD_STDNAME, entry.stdfield1);
        values.put(DatabaseHandler.KEY_FIELD_STDCODE, entry.stdfield2);
        values.put(DatabaseHandler.KEY_FIELD_STDSEM, entry.stdfield3);
        values.put(DatabaseHandler.KEY_FIELD_STDMAIL, entry.stdfield4);

        Long index = mDatabase.insert(DatabaseHandler.TABLE_STD,null,values);

        return index;
    }

    // Adding database support to rubric
    public long addDataEntryRubric(DataEntryRubric entry) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.KEY_FIELD_RUBRIC_NAME, entry.rbcfield0);

        Long index = mDatabase.insert(DatabaseHandler.TABLE_RUBRIC,null,values);

        return index;
    }


    public long addDataEntryCategory(DataEntryCategory entry) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.KEY_FIELD_CTG_NAME, entry.catfield1);
        values.put(DatabaseHandler.KEY_FIELD_CTG_WEIGHT, entry.catfield2);
        values.put(DatabaseHandler.KEY_ID_RBC, entry.catfield0);

        Long index = mDatabase.insert(DatabaseHandler.TABLE_CTG,null,values);

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
                        entry.stdfield0 = cursor.getString(1);
                        entry.stdfield1 = cursor.getString(2);
                        entry.stdfield2 = cursor.getString(3);
                        entry.stdfield3 = cursor.getString(4);
                        entry.stdfield4 = cursor.getString(5);
                        entryList.add(entry);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                break;
            case DatabaseHandler.TABLE_RUBRIC:
                if (cursor.moveToFirst()) {
                    do {
                        DataEntryRubric entry = new DataEntryRubric();
                        entry.idRubric = Integer.parseInt(cursor.getString(0));
                        entry.rbcfield0 = cursor.getString(1);
                        entryList.add(entry);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                break;
            case DatabaseHandler.TABLE_CTG:
                if (cursor.moveToFirst()) {
                    do {
                        DataEntryCategory entry = new DataEntryCategory();
                        entry.idCategory = Integer.parseInt(cursor.getString(0));
                        entry.catfield0 = cursor.getString(1);
                        entry.catfield1 = cursor.getString(2);
                        entry.catfield2 = cursor.getString(3);
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

    // Getting specific entry
    public DataEntry getDataEntry(int id, String table_name, String key_id, String key_field) {

        Log.d(TAG, "getDataEntry " + id);

        Cursor cursor = mDatabase.query(
                table_name,
                new String[] { key_id, key_field},
                key_id + "=?",
                new String[] { String.valueOf(id) },
                null,
                null,
                null,
                null
        );

        if (cursor != null)
            cursor.moveToFirst();

        DataEntry entry = new DataEntry(
                Integer.parseInt(cursor.getString(0)),
                (cursor.getString(1)));

        Log.d(TAG,"getDataEntry " + entry);

        cursor.close();
        return entry;
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

    public void deleteEntryRubric(DataEntryRubric entry) {
        mDatabase.delete(DatabaseHandler.TABLE_RUBRIC, DatabaseHandler.KEY_ID_RBC + " = ?",
                new String[] { String.valueOf(entry.idRubric) }
        );
    }

    // Query student list based on subject name column
    public List<DataEntry> selectStudentBySubject(String table_name, String rowName, String rowQuery) {
        Log.d(TAG, "get student list of subject: " + rowName);

        List<DataEntry> entryList = new ArrayList<>();

        // select All Querry
        String selectQuery = "SELECT * FROM " + table_name + " WHERE " + rowName + "='" + rowQuery + "'";

        Cursor cursor = mDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DataEntryStd entry = new DataEntryStd();
                entry.idSubj = Integer.parseInt(cursor.getString(0));
                entry.stdfield0 = cursor.getString(1);
                entry.stdfield1 = cursor.getString(2);
                entry.stdfield2 = cursor.getString(3);
                entry.stdfield3 = cursor.getString(4);
                entry.stdfield4 = cursor.getString(5);
                entryList.add(entry);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return entryList;
    }

    public List<DataEntry> selectAllTable (String table_name) {
        List<DataEntry> entryList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + table_name;

        Cursor cursor = mDatabase.rawQuery(selectQuery, null);

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
                        entry.stdfield0 = cursor.getString(1);
                        entry.stdfield1 = cursor.getString(2);
                        entry.stdfield2 = cursor.getString(3);
                        entry.stdfield3 = cursor.getString(4);
                        entry.stdfield4 = cursor.getString(5);
                        entryList.add(entry);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                break;
            case DatabaseHandler.TABLE_RUBRIC:
                if (cursor.moveToFirst()) {
                    do {
                        DataEntryRubric entry = new DataEntryRubric();
                        entry.idRubric = Integer.parseInt(cursor.getString(0));
                        entry.rbcfield0 = cursor.getString(1);
                        entryList.add(entry);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                break;
            case DatabaseHandler.TABLE_CTG:
                if (cursor.moveToFirst()) {
                    do {
                        DataEntryCategory entry = new DataEntryCategory();
                        entry.idCategory = Integer.parseInt(cursor.getString(0));
                        entry.catfield0 = cursor.getString(1);
                        entry.catfield1 = cursor.getString(2);
                        entry.catfield2 = cursor.getString(3);
                        entryList.add(entry);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                break;
        }

        cursor.close();

        return entryList;
    }

}
