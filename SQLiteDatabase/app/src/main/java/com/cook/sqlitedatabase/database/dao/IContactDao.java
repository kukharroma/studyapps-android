package com.cook.sqlitedatabase.database.dao;

import com.cook.sqlitedatabase.model.Contact;

import java.util.List;

/**
 * Created by roma on 01.02.16.
 */
public interface IContactDao {
    void addContact(Contact contact);
    Contact getContact(int id);
    List<Contact> getAllContacts();
    int getContactsCount();
    int updateContact(Contact contact);
    void deleteContact();
}
