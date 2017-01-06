package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertTransactionPresenter implements CRUD.Insert.Presenter<Transaction> {

    private final CRUD.Insert.View<Transaction> mView;

    public InsertTransactionPresenter(CRUD.Insert.View<Transaction> mView) {
        this.mView = mView;
    }

    @Override
    public void insert(Transaction transaction) {
        new CRUDTransactions().insert(transaction);
        mView.getActivity().showMessage("Transaction has been created");
    }


}