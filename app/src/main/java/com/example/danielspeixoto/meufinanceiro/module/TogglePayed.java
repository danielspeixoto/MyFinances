package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class TogglePayed {

    public interface View extends Base.View {

    }

    public interface Presenter extends Base.Presenter {
        void toggle(Transaction transaction);
    }

}
