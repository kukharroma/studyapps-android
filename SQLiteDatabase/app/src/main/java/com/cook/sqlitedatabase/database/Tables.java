package com.cook.sqlitedatabase.database;

/**
 * Created by roma on 01.02.16.
 */
public interface Tables {

    String CONTACTS = "contacts";

    interface Contacts {
        String ID = "id";
        String NAME = "name";
        String PHONE_NUMBER = "phoneNumber";
     }
}
