package com.superatom.javamovie.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static Date strToDate(String strDate) {
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(strDate, pos);
        return date;
    }
}
