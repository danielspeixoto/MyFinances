package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class TogglePayed {

    public interface View extends ActivityBase.View {

    }

    public interface Presenter extends ActivityBase.Presenter {
        void toggle(Transaction transaction);
    }

}
