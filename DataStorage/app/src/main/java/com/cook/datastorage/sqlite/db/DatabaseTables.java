package com.cook.datastorage.sqlite.db;

/**
 * Created by roma on 01.02.16.
 */
public interface DatabaseTables {

    String CONTACTS = "contacts";

    interface Contacts {
        String ID = "id";
        String NAME = "name";
        String PHONE_NUMBER = "phoneNumber";
     }
}
