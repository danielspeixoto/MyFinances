package com.example.danielspeixoto.meufinanceiro.util;

import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class Convert {

    public static String dateToString(DatePicker datePicker) {
        String date = "";
        date += datePicker.getDayOfMonth() < 10 ? "0" + datePicker.getDayOfMonth() : datePicker.getDayOfMonth();
        date += "/";
        date += datePicker.getMonth() + 1 < 10 ? "0" + (datePicker.getMonth() + 1) : (datePicker.getMonth() + 1);
        return date + "/" + datePicker.getYear();
    }

    public static String calendarToString(Calendar calendar) {
        String date = "";
        date += calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH);
        date += "/";
        date += calendar.get(Calendar.MONTH) < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1): (calendar.get(Calendar.MONTH) + 1);
        return date + "/" + calendar.get(Calendar.YEAR);
    }
}
