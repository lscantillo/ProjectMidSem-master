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
    public static final String TABLE_RUBRIC = "rubricTable";
    public static final String TABLE_CTG = "categoryTable";
    public static final String TABLE_ELM = "elementTable";

    // Table Columns Names for Subjects
    public static final String KEY_ID = "subjectId";
    public static final String KEY_FIELD1 = "subjectName";

    // Table Columns Names for Students
    public static final String KEY_ID_STD = "studentId";
    public static final String KEY_FIELD_SUBJECT = "studentSubjectId";
    public static final String KEY_FIELD_STDNAME = "studentName";
    public static final String KEY_FIELD_STDCODE = "studentCode";
    public static final String KEY_FIELD_STDSEM = "studentSem";
    public static final String KEY_FIELD_STDMAIL = "studentMail";

    // ------------------ Tables for Rubrics Activity ------------------ //
    // Table Columns Names for Rubrics
    public static final String KEY_ID_RBC = "rubricId";
    public static final String KEY_FIELD_RUBRIC_NAME = "rubricName";

    // Table Columns Names for Categories
    public static final String KEY_ID_CTG = "categoryId";
    public static final String KEY_FIELD_CTG_NAME = "categoryName";
    public static final String KEY_FIELD_CTG_WEIGHT = "categoryWeight";

    // Table Columns Names for Elements / Levels
    public static final String KEY_ID_ELM = "elementId";
    public static final String KEY_FIELD_ELM_NAME = "elementName";
    public static final String KEY_FIELD_ELM_WEIGHT = "elementWeight";
    public static final String KEY_FIELD_ELM_LONE = "elementLvlOne";
    public static final String KEY_FIELD_ELM_LTWO = "elementLvlTwo";
    public static final String KEY_FIELD_ELM_LTHREE = "elementLvlThree";
    public static final String KEY_FIELD_ELM_LFOUR = "elementLvlFour";

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
        String CREATE_TABLE_STD = "CREATE TABLE " + TABLE_STD + " (" + KEY_ID_STD
                + " integer primary key," + KEY_FIELD_SUBJECT
                + " integer," + KEY_FIELD_STDNAME + " integer," + KEY_FIELD_STDCODE
                + " integer," + KEY_FIELD_STDSEM + " integer,"  + KEY_FIELD_STDMAIL
                + " integer" + ") ";
        String CREATE_TABLE_RUBRIC = "CREATE TABLE " + TABLE_RUBRIC + " (" +
                KEY_ID_RBC + " integer primary key," +
                KEY_FIELD_RUBRIC_NAME + " text" +
                ") ";
        String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TABLE_CTG + " (" +
                KEY_ID_CTG + " integer primary key," +
                KEY_ID_RBC + " integer," +
                KEY_FIELD_CTG_NAME + " text," +
                KEY_FIELD_CTG_WEIGHT + " integer," +
                "foreign key(" + KEY_ID_RBC + ")" + " references " + TABLE_RUBRIC + "(" + KEY_ID_RBC + ") " +
                ") ";
        String CREATE_TABLE_ELEMENTS = "CREATE TABLE " + TABLE_ELM + " (" +
                KEY_ID_ELM + " integer primary key," +
                KEY_ID_CTG + " integer," +
                KEY_FIELD_ELM_NAME + " text," +
                KEY_FIELD_ELM_WEIGHT + " integer," +
                KEY_FIELD_ELM_LONE + " text," +
                KEY_FIELD_ELM_LTWO + " text," +
                KEY_FIELD_ELM_LTHREE + " text," +
                KEY_FIELD_ELM_LFOUR + " text," +
                "foreign key(" + KEY_ID_CTG + ")" + " references " + TABLE_CTG + "(" + KEY_ID_CTG + ") " +
                ") ";

//        id INTEGER,
//        orderID INTEGER,
//        itemId  INTEGER,
//        quantity INTEGER,
//        FOREIGN KEY(orderId) REFERENCES order(Id),
//                FOREIGN KEY(itemId) REFERENCES item(Id)
        if (db.isOpen()){
            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_TABLE_STD);
            db.execSQL(CREATE_TABLE_RUBRIC);
            db.execSQL(CREATE_TABLE_CATEGORY);
            db.execSQL(CREATE_TABLE_ELEMENTS);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d(TAG, "onUpgrade DB");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
    }
}
