package com.cook.datastorage.externalStorage;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.cook.datastorage.helper.FileHelper;

import java.io.File;
import java.io.IOException;

/**
 * Created by roma on 19.02.16.
 */
public class ExternalStorageManager {

    private static Context context;
    private static final String TAG = "ExternalStorageManager";
    private static final String EXTERNAL_FILE_NAME = "EXTERNAL_FILE_NAME.txt";

    public static void init(Context context) {
        ExternalStorageManager.context = context;
    }

    /**
     * Checks if external storage is available for read and write
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if external storage is available to at least read
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Creates a directory for a new photo album in the public pictures directory:
     */
    public static File getAlbumStorageDir(String albumName) {
        File f = Environment.getExternalStoragePublicDirectory(null);

        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }

    /**
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static File getExternalDir() {
        File file = new File(context.getExternalMediaDirs()[1].getAbsolutePath(), EXTERNAL_FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static File getExternalCacheDir() {
        File file = new File(context.getExternalCacheDir(), EXTERNAL_FILE_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void saveInExternalDir(String text) {
        FileHelper.saveInFile(text, getExternalDir());
    }

    public static String loadExternalDir() {
        return FileHelper.loadFromFile(getExternalDir());
    }

    public static void saveInExternalCacheDir(String text) {
        FileHelper.saveInFile(text, getExternalCacheDir());
    }

    public static String loadInternalCacheDir() {
        return FileHelper.loadFromFile(getExternalCacheDir());
    }


}
