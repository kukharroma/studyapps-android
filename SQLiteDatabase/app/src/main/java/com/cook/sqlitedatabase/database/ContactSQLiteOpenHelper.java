package com.cook.sqlitedatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by roma on 01.02.16.
 */
public class ContactSQLiteOpenHelper extends SQLiteOpenHelper {

    private static ContactSQLiteOpenHelper instance;

    public static ContactSQLiteOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new ContactSQLiteOpenHelper(context);
        }
        return instance;
    }

    public ContactSQLiteOpenHelper(Context context) {
        super(context, DBConfig.DATABASE_NAME, null, DBConfig.DATABASE_VERSION);
        instance = this;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TABLES = "CREATE TABLE " + Tables.CONTACTS + "("
                + Tables.Contacts.ID + " INTEGER PRIMARY KEY," + Tables.Contacts.NAME + " TEXT,"
                + Tables.Contacts.PHONE_NUMBER + " TEXT" + ")";
        database.execSQL(CREATE_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String DELETE_TABLES = "DROP TABLE IF EXISTS " + Tables.CONTACTS;
        database.execSQL(DELETE_TABLES);
        onCreate(database);
    }
}
