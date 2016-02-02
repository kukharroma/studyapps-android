package com.cook.customcontentprovider.provider;

import android.net.Uri;

/**
 * Created by roma on 02.02.16.
 */
public interface StudentProviderConstants {

    String AUTHORITY = "com.example.provider.College";
    String URL = "content://" + AUTHORITY + "/students";
    Uri CONTENT_URI = Uri.parse(URL);

    String STUDENTS_PATH = "students";
    String STUDENTS_PATH_ID = "students/#";

    int STUDENTS = 1;
    int STUDENT_ID = 2;

}
