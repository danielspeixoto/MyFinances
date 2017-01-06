package com.example.danielspeixoto.meufinanceiro.util;

import android.widget.DatePicker;

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
}
