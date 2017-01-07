package com.example.danielspeixoto.meufinanceiro.module;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class DateGetter {

    public interface View {
        void setDate(String date);
        void show();
    }

    public interface Presenter {
        void getDate(String date);
    }
}
