package com.cook.sqlitedatabase.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cook.sqlitedatabase.database.ContactSQLiteOpenHelper;
import com.cook.sqlitedatabase.database.Tables;
import com.cook.sqlitedatabase.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 01.02.16.
 */
public class ContactDao implements IContactDao {

    private Context context;

    public ContactDao(Context context) {
        this.context = context;
    }

    @Override
    public void addContact(Contact contact) {
        SQLiteDatabase db = ContactSQLiteOpenHelper.getInstance(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tables.Contacts.NAME, contact.getName());
        values.put(Tables.Contacts.PHONE_NUMBER, contact.getPhoneNumber());

        db.insert(Tables.CONTACTS, null, values);
        db.close();
    }

    @Override
    public Contact getContact(int id) {
        SQLiteDatabase db = ContactSQLiteOpenHelper.getInstance(context).getReadableDatabase();

        Cursor cursor = db.query(Tables.CONTACTS, new String[]{
                        Tables.Contacts.ID,
                        Tables.Contacts.NAME,
                        Tables.Contacts.PHONE_NUMBER
                },
                Tables.Contacts.ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        int userId = Integer.parseInt(cursor.getString(0));
        String userName = cursor.getString(1);
        String userPhoneNumber = cursor.getString(2);

        return new Contact(userId, userName, userPhoneNumber);
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();

        String selectQuery = "SELECT  * FROM " + Tables.CONTACTS;

        SQLiteDatabase db = ContactSQLiteOpenHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return contactList;
    }

    @Override
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + Tables.CONTACTS;
        SQLiteDatabase db = ContactSQLiteOpenHelper.getInstance(context).getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    @Override
    public int updateContact(Contact contact) {
        SQLiteDatabase db = ContactSQLiteOpenHelper.getInstance(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tables.Contacts.NAME, contact.getName());
        values.put(Tables.Contacts.PHONE_NUMBER, contact.getPhoneNumber());

        return db.update(Tables.CONTACTS, values, Tables.Contacts.ID + " = ?", new String[]{String.valueOf(contact.getId())});
    }

    @Override
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = ContactSQLiteOpenHelper.getInstance(context).getWritableDatabase();
        db.delete(Tables.CONTACTS, Tables.Contacts.ID + " = ?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }
}
