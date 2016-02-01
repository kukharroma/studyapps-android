package com.cook.customcontentprovider.app;

import android.app.Application;

import com.cook.customcontentprovider.R;
import com.cook.customcontentprovider.database.DBConfig;

/**
 * Created by roma on 01.02.16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBConfig.DATABASE_NAME = getString(R.string.database_name);
        DBConfig.DATABASE_VERSION = getResources().getInteger(R.integer.database_version);
    }
}
