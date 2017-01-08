package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class ActivityBase {

    public interface Presenter {

    }

    public interface View {

        BaseActivity getActivity();
        void goToActivity(Class clazz);
    }
}