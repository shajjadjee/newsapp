package com.newspaperboot.bookmark;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static com.newspaperboot.bookmark.DbHelper dbHelper = null;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mydb.db";


    public static com.newspaperboot.bookmark.DbHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new com.newspaperboot.bookmark.DbHelper(context);
        }
        return dbHelper;
    }

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbConstants.SQL_CREATE_NOTIFICATION_ENTRIES);
        db.execSQL(DbConstants.SQL_CREATE_FAVORITE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DbConstants.SQL_DELETE_NOTIFICATION_ENTRIES);
        db.execSQL(DbConstants.SQL_DELETE_FAVORITE_ENTRIES);

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}