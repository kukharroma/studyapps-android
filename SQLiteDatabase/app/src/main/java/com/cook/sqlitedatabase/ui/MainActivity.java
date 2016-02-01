package com.cook.sqlitedatabase.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cook.sqlitedatabase.R;
import com.cook.sqlitedatabase.database.dao.ContactDao;
import com.cook.sqlitedatabase.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactDao contactDao = new ContactDao(this);
        contactDao.addContact(new Contact("name0", "0123456789"));
        contactDao.addContact(new Contact("name1", "0123456789"));
        contactDao.addContact(new Contact("name2", "0123456789"));
        contactDao.addContact(new Contact("name3", "0123456789"));
        contactDao.addContact(new Contact("name4", "0123456789"));

        List<Contact> contacts = contactDao.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            Log.i("Contact: ---> ", log);
        }
    }
}
