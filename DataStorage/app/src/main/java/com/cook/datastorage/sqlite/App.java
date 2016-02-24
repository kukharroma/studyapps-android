package com.cook.datastorage.sqlite;

import android.app.Application;

import com.cook.datastorage.R;
import com.cook.datastorage.sqlite.db.DatabaseConfig;


/**
 * Created by roma on 01.02.16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseConfig.DATABASE_NAME = getResources().getString(R.string.database_name);
        DatabaseConfig.DATABASE_VERSION = getResources().getInteger(R.integer.database_version);
    }
}
