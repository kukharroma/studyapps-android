package com.cook.datastorage.internalStorage;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by roma on 18.02.16.
 */
public class InternalStorageManager {

    private static Context context;
    private static InternalStorageManager instance = null;

    private static final String FILE_NAME = "test_file";

    public static InternalStorageManager getInstance() {
        if (instance == null)
            instance = new InternalStorageManager();
        return instance;
    }

    public static void saveName(String name) {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(name.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getName() {
        StringBuilder name = new StringBuilder();
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                name.append(line);
            }
            reader.close();
        } catch (IOException e) {

        }
        return name.toString();
    }
}
