package com.bulutfon.bulutfonandroidsdk.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by htkaya on 23/09/16.
 */
public class Utilities {
    public static Date getDateFromJson(String result) {
        Date date = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        if(!result.equals("null")) {
            try {
                date = format.parse(result);
            } catch (ParseException e) {
                try {
                    date = format2.parse(result);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return date;
    }

    public static String getStringFromJson(String result) {
        if(result.equals("null")) {
            return null;
        } else {
            return result;
        }
    }
}
