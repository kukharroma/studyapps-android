package com.cook.datastorage.internalStorage;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by roma on 18.02.16.
 * <p/>
 * You can saveInExternalFile files directly on the device's internal storage.
 * By default, files saved to the internal storage are private to your
 * application and other applications cannot access them (nor can the user).
 * When the user uninstalls your application, these files are removed.
 */
public class InternalStorageManager {

    private static Context context;

    public static final String FILE_NAME = "test_file_name";

    public static void init(Context context) {
        InternalStorageManager.context = context;
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

    /**
     * /**
     * /data/user/0/com.cook.datastorage/cache ---> directory of cache
     * return ---> directory created by context ---> context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
     *
     * @return Gets the absolute path to the filesystem directory where your internal files are saved.
     */
    public static File getDirCache() {
        return context.getCacheDir();
    }

    /**
     * чомусь додається  префікс "app" до назви файла. ?!?!?!*88$%$%
     * <p/>
     * /data/user/0/com.cook.datastorage/app_test_file_name TODO app_test_file_name
     * return ---> directory created by context ---> context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
     *
     * @return Creates (or opens an existing) directory within your internal storage space.
     */
    public static File getDir(String fileName) {
        return context.getDir(fileName, Context.MODE_PRIVATE);
    }

    /**
     * Deletes a file saved on the internal storage.
     * <p/>
     * Delete file from directory "files"
     *
     * @param fileName name of dir
     */
    public static void deleteFile(String fileName) {
        context.deleteFile(fileName);
    }

    /**
     * Returns an array of files currently saved by your application.
     * <p/>
     * [test_file_name]
     */
    public static String[] fileList() {
        return context.fileList();
    }
}
