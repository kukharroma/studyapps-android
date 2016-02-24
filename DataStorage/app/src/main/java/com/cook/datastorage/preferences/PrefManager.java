package com.cook.datastorage.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by roma on 18.02.16.
 */
public class PrefManager {

    private Context context;
    private PrefManager instance;
    private static SharedPreferences preferences;

    private static String SHARED_PREF_NAME = "shared_pref_name";
    private static String KEY_NAME = "KEY_NAME";

    private PrefManager() {
        preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public PrefManager getInstance() {
        if (instance == null)
            instance = new PrefManager();
        return instance;
    }

    public static void saveData(String name) {
        preferences.edit().putString(KEY_NAME, name).apply();
    }

    public static String getData(){
        return preferences.getString(KEY_NAME, "");
    }
}
