package com.cook.customcontentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.cook.customcontentprovider.database.DatabaseHelper;
import com.cook.customcontentprovider.database.Tables;

import java.util.HashMap;
import java.util.Map;

import static com.cook.customcontentprovider.provider.StudentProviderConstants.AUTHORITY;
import static com.cook.customcontentprovider.provider.StudentProviderConstants.CONTENT_URI;
import static com.cook.customcontentprovider.provider.StudentProviderConstants.STUDENTS;
import static com.cook.customcontentprovider.provider.StudentProviderConstants.STUDENTS_PATH;
import static com.cook.customcontentprovider.provider.StudentProviderConstants.STUDENTS_PATH_ID;
import static com.cook.customcontentprovider.provider.StudentProviderConstants.STUDENT_ID;

/**
 * Created by roma on 01.02.16.
 */
public class StudentProvider extends ContentProvider {

    private SQLiteDatabase db;
    private UriMatcher uriMatcher;
    private static Map<String, String> STUDENTS_PROJECTION_MAP = new HashMap<>();

    @Override
    public boolean onCreate() {
        initMatcher();
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(getContext());
        db = dbHelper.getWritableDatabase();
        return (db != null);
    }

    private void initMatcher() {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, STUDENTS_PATH, STUDENTS);
        uriMatcher.addURI(AUTHORITY, STUDENTS_PATH_ID, STUDENT_ID);
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        long rowID = db.insert(Tables.STUDENTS, "", values);
        if (rowID > 0) {
            Uri newUri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            if (getContext() != null)
                getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }

        throw new SQLException("Failed to add a record into " + uri);
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(Tables.STUDENTS);
        switch (uriMatcher.match(uri)) {
            case STUDENTS:
                qb.setProjectionMap(STUDENTS_PROJECTION_MAP);
                break;
            case STUDENT_ID:
                qb.appendWhere(Tables.Students.ID + "=" + uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        if (sortOrder == null || TextUtils.isEmpty(sortOrder)) {
            sortOrder = Tables.Students.NAME;
        }
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        if (getContext() != null)
            c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)) {
            case STUDENTS:
                count = db.delete(Tables.STUDENTS, selection, selectionArgs);
                break;
            case STUDENT_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(Tables.STUDENTS, Tables.Students.ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (getContext() != null)
            getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)) {
            case STUDENTS:
                count = db.update(Tables.STUDENTS, values, selection, selectionArgs);
                break;

            case STUDENT_ID:
                count = db.update(Tables.STUDENTS, values, Tables.Students.ID + " = " + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (getContext() != null)
            getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case STUDENTS:
                return "vnd.android.cursor.dir/vnd.example.students";
            case STUDENT_ID:
                return "vnd.android.cursor.item/vnd.example.students";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }
}
