package com.cook.datastorage.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by roma on 23.02.16.
 */
public class FileHelper {

    public static void saveInFile(String data, File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadFromFile(File file) {
        StringBuilder name = new StringBuilder();
        FileInputStream fis = null;
        BufferedReader reader = null;
        try {
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));
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
}
