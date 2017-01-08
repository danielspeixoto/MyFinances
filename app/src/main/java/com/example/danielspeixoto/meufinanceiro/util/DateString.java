package com.example.danielspeixoto.meufinanceiro.util;

import java.util.Calendar;

import lombok.Data;

/**
 * Created by danielspeixoto on 1/6/17.
 */

@Data
public class DateString {

    final static int MONTHLY = -1;

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
        return getCalendar(new DateString(date1)).compareTo(getCalendar(new DateString(date2)));
    }

    private static Calendar getCalendar(DateString dateString) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(dateString.stringToYear(), dateString.stringToMonth(), dateString.stringToDay());
        return calendar;
    }

    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        return Convert.calendarToString(calendar);
    }

    public static String sumPeriod(String date, int period) {
        Calendar calendar;
        calendar = getCalendar(new DateString(date));
        if(period == MONTHLY) {
            calendar.add(Calendar.MONTH, 1);
            return Convert.calendarToString(calendar);
        }
        calendar.add(Calendar.DATE, period);
        return Convert.calendarToString(calendar);
    }

}
