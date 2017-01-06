package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class Base {

    public interface Presenter {
        void onError(String message);
    }

    public interface View {
        BaseActivity getActivity();
        void onError(String message);
    }
}