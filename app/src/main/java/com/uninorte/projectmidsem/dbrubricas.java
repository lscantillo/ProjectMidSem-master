package com.uninorte.projectmidsem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by luise on 17/09/2017.
 */

public class dbrubricas extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "rubricas";
        public static final String COLUMN_NAME_CATEGORIAS = "categorias";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                        FeedEntry.TABLE_NAME + TEXT_TYPE +COMMA_SEP+
                        FeedEntry.COLUMN_NAME_CATEGORIAS + TEXT_TYPE + COMMA_SEP +
                         " )";
        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    }


    public dbrubricas(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(FeedEntry.SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(FeedEntry.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }
}
