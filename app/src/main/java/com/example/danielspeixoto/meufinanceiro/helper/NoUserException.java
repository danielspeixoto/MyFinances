package com.example.danielspeixoto.meufinanceiro.helper;

import android.util.Log;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class NoUserException extends Exception {

    @Override
    public String getMessage() {
        return "No user is logged";
    }

    @Override
    public void printStackTrace() {
        Log.d("NoUserException", "No user is logged");
    }
}
