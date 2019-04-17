package com.test.csv.utils;

import java.util.Date;

public class DateUtils {

    public static Date unixTimeToDate(Long unixTime) {
        Date date = new Date ();
        date.setTime(unixTime*1000);
        return date;
    }

    public static long dateToUnixTime(Date date) {
        return date.getTime();
    }

}
