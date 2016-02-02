package com.cook.customcontentprovider.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by roma on 01.02.16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static DatabaseHelper instance;

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            return new DatabaseHelper(context);
        }
        return instance;
    }

    public DatabaseHelper(Context context) {
        super(context, DBConfig.DATABASE_NAME, null, DBConfig.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DB_TABLE = " CREATE TABLE " + Tables.STUDENTS +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Tables.Students.NAME + " TEXT NOT NULL, " +
                        Tables.Students.GRADE + " grade TEXT NOT NULL);";
        db.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tables.STUDENTS);
        onCreate(db);
    }

}
