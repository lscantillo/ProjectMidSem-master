package com.uninorte.projectmidsem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    public String TAG = Constants.TAG;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "mainDatabase";

    // Table Name
    public static final String TABLE = "subjectTable";

    // Table Columns Names
    public static final String KEY_ID = "subjectId";
    public static final String KEY_FIELD1 = "subjectName";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d(TAG, "DatabaseHandler constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate DB");
        // SQL Sentence for create the table
        String CREATE_TABLE = "CREATE TABLE " + TABLE + " (" +
                KEY_ID + " integer primary key," + KEY_FIELD1 + " integer" + ") ";
        if (db.isOpen()){
            db.execSQL(CREATE_TABLE);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d(TAG, "onUpgrade DB");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
    }
}
