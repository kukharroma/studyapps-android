package com.cook.customcontentprovider.provider;

import android.net.Uri;

/**
 * Created by roma on 02.02.16.
 */
public class StudentProviderConstants {


    public static final String AUTHORITY = "com.example.provider.College";
    public static final String URL = "content://" + AUTHORITY + "/students";
    public static final Uri CONTENT_URI = Uri.parse(URL);

    public static final String STUDENTS_PATH = "students";
    public static final String STUDENTS_PATH_ID = "students/#";

    public static final int STUDENTS = 1;
    public static final int STUDENT_ID = 2;



}
