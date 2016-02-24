package com.cook.datastorage.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by roma on 01.02.16.
 */
public class DatabaseSQLiteOpenHelper extends SQLiteOpenHelper {

    private static DatabaseSQLiteOpenHelper instance;

    public static DatabaseSQLiteOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseSQLiteOpenHelper(context);
        }
        return instance;
    }

    public DatabaseSQLiteOpenHelper(Context context) {
        super(context, DatabaseConfig.DATABASE_NAME, null, DatabaseConfig.DATABASE_VERSION);
        instance = this;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TABLES = "CREATE TABLE " + DatabaseTables.CONTACTS + "("
                + DatabaseTables.Contacts.ID + " INTEGER PRIMARY KEY," + DatabaseTables.Contacts.NAME + " TEXT,"
                + DatabaseTables.Contacts.PHONE_NUMBER + " TEXT" + ")";
        database.execSQL(CREATE_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String DELETE_TABLES = "DROP TABLE IF EXISTS " + DatabaseTables.CONTACTS;
        database.execSQL(DELETE_TABLES);
        onCreate(database);
    }
}
