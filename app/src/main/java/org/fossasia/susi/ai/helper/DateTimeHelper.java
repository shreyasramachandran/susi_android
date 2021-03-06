package org.fossasia.susi.ai.helper;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * <h1>Helper class to get current date and time. Also to parse date and time from server.</h1>
 *
 * Created by
 * --Vatsal Bajpai on
 * --05/10/16 at
 * --6:51 AM
 */
public class DateTimeHelper {

    /**
     * Gets current time.
     *
     * @return the current time
     */
    public static String getCurrentTime() {
        String delegate = "hh:mm aaa";
        return (String) DateFormat.format(delegate,Calendar.getInstance().getTime());
    }

    /**
     * Get date string.
     *
     * @return the string
     */
    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(" MMM dd, yyyy");
        return sdf.format(new Date());
    }

    /**
     * Method to format date from server
     *
     * @param date Date in string
     * @return Date
     */
    private static Date formatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date dateIn;
        try {
            dateIn = sdf.parse(date);
        } catch (Exception e) {
            dateIn = null;
        }
        return dateIn;
    }

    /**
     * Get date string.
     *
     * @param date the date
     * @return the string
     */
    public static String getDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat(" MMM dd, yyyy");
        TimeZone tz = TimeZone.getDefault();
        sdf.setTimeZone(tz);
        return sdf.format(formatDate(date));
    }

    /**
     * Gets time.
     *
     * @param date the date
     * @return the time
     */
    public static String getTime(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aaa");
        TimeZone tz = TimeZone.getDefault();
        sdf.setTimeZone(tz);
        return sdf.format(formatDate(date));
    }
}
