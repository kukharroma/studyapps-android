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
    private static final String EXTERNAL_FILE_NAME = "test.txt";
    private static final int LOCALE_STORAGE_POSITION = 0;
    private static final int SD_CARD_POSITION = 1;

    public static void init(Context context) {
        ExternalStorageManager.context = context;
    }

    /**
     * Checks if external storage is available for read and write
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /**
     * Checks if external storage is available to at least read
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static File getExternalDir() {
        File file = new File(context.getExternalMediaDirs()[LOCALE_STORAGE_POSITION].getAbsolutePath(), EXTERNAL_FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static File getExternalCacheDir() {
        File file = new File(context.getExternalCacheDirs()[LOCALE_STORAGE_POSITION], EXTERNAL_FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static File getExternalSdCardDir() {
        File file = new File(context.getExternalMediaDirs()[SD_CARD_POSITION].getAbsolutePath(), EXTERNAL_FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static File getExternalSdCardCacheDir() {
        File file = new File(context.getExternalCacheDirs()[SD_CARD_POSITION], EXTERNAL_FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public static String loadExternalCacheDir() {
        return FileHelper.loadFromFile(getExternalCacheDir());
    }

    public static void saveInExternalSdCardDir(String text) {
        FileHelper.saveInFile(text, getExternalSdCardDir());
    }

    public static String loadExternalSdCardDir() {
        return FileHelper.loadFromFile(getExternalSdCardDir());
    }

    public static void saveInExternalSdCardCacheDir(String text) {
        FileHelper.saveInFile(text, getExternalSdCardCacheDir());
    }

    public static String loadExternalSdCardCacheDir() {
        return FileHelper.loadFromFile(getExternalSdCardCacheDir());
    }


}
