package com.example.danielspeixoto.meufinanceiro.util;

import java.util.Calendar;

import lombok.Data;

/**
 * Created by danielspeixoto on 1/6/17.
 */

@Data
public class DateString {

    String date;

    public DateString(String date) {
        this.date = date;
    }

    public int stringToYear() {
        return Integer.valueOf(date.substring(6));
    }

    public int stringToMonth() {
        return Integer.valueOf(date.substring(3, 5)) -1;
    }

    public int stringToDay() {
        return Integer.valueOf(date.substring(0, 2));
    }

    public static int compareDates(String date1, String date2) {
        return getCalendar(new DateString(date2)).compareTo(getCalendar(new DateString(date1)));
    }

    private static Calendar getCalendar(DateString dateString) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(dateString.stringToYear(), dateString.stringToMonth(), dateString.stringToDay());
        return calendar;
    }

    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        String date = "";
        date += calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH);
        date += "/";
        date += calendar.get(Calendar.MONTH) < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1): (calendar.get(Calendar.MONTH) + 1);
        return date + "/" + calendar.get(Calendar.YEAR);
    }


}
