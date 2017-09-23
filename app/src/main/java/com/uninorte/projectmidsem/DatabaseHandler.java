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

    // Table Names
    public static final String TABLE = "subjectTable";
    public static final String TABLE_STD = "studentTable";

    // Table Columns Names for Subjects
    public static final String KEY_ID = "subjectId";
    public static final String KEY_FIELD1 = "subjectName";

    // Table Columns Names for Students
    public static final String KEY_ID_STD = "studentSubjectID";
    public static final String KEY_FIELD_STDNAME = "studentName";
    public static final String KEY_FIELD_STDCODE = "studentCode";
    public static final String KEY_FIELD_STDSEM = "studentSem";
    public static final String KEY_FIELD_STDMAIL = "studentMail";


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
        String CREATE_TABLE_STD = "CREATE TABLE " + TABLE_STD + " (" +
                KEY_ID_STD + " integer primary key," + KEY_FIELD_STDNAME + " integer," + KEY_FIELD_STDCODE + " integer," + KEY_FIELD_STDSEM + " integer," + KEY_FIELD_STDMAIL + ") ";
        if (db.isOpen()){
            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_TABLE_STD);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d(TAG, "onUpgrade DB");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
    }
}
