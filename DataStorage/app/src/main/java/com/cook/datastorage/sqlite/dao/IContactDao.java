package com.cook.datastorage.sqlite.dao;

import com.cook.datastorage.sqlite.model.Contact;

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
    void deleteContact(Contact contact);
}
