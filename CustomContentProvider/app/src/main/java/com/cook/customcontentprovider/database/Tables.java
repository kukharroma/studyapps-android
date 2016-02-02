package com.cook.customcontentprovider.database;

/**
 * Created by roma on 01.02.16.
 */
public interface Tables {

    String STUDENTS = "students";

    interface Students{
        String ID = "_id";
        String NAME = "name";
        String GRADE = "grade";
    }
}
