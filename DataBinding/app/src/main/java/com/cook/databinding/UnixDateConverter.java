package com.cook.databinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by roma on 09.02.16.
 */
public class UnixDateConverter {

    public static String convert(long timestamp) {
        Calendar mydate = Calendar.getInstance();
        mydate.setTimeInMillis(timestamp * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(mydate.getTime());
    }
}
