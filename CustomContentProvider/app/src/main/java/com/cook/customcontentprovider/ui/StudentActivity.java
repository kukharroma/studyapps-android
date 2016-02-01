package com.cook.customcontentprovider.ui;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cook.customcontentprovider.R;
import com.cook.customcontentprovider.provider.StudentProvider;

/**
 * Created by roma on 01.02.16.
 */
public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    public void onClickAddName(View view) {
        ContentValues values = new ContentValues();
        values.put(StudentProvider.NAME, ((EditText) findViewById(R.id.editText2)).getText().toString());
        values.put(StudentProvider.GRADE, ((EditText) findViewById(R.id.editText3)).getText().toString());
        Uri uri = getContentResolver().insert(StudentProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view) {

        // Retrieve student records
        String URL = "content://com.example.provider.College/students";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do {
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentProvider._ID)) +
                                ", " + c.getString(c.getColumnIndex(StudentProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex(StudentProvider.GRADE)), Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}
