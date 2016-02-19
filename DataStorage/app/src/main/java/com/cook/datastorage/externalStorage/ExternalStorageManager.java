package com.cook.datastorage.externalStorage;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by roma on 19.02.16.
 */
public class ExternalStorageManager {

    /**
     * Checks if external storage is available for read and write
     */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if external storage is available to at least read
     */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * Creates a directory for a new photo album in the public pictures directory:
     *
     * @param albumName
     * @return
     */
    public File getAlbumStorageDir(String albumName) {
        File f = Environment.getExternalStoragePublicDirectory(null);

        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e(getClass().getSimpleName(), "Directory not created");
        }
        return file;
    }

}
