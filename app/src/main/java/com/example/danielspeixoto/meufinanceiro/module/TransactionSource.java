package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class TransactionSource {

    public interface View extends Base.View {

        void addItem(Transaction transaction);

    }

    public interface Presenter extends Base.Presenter {

        void selectAll();

    }
}
