package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.InsertTransaction;
import com.example.danielspeixoto.meufinanceiro.util.Repeated;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertTransactionPresenter implements InsertTransaction.Presenter {

    private final InsertTransaction.View mView;

    public InsertTransactionPresenter(InsertTransaction.View mView) {
        this.mView = mView;
    }

    @Override
    public void insert(Transaction transaction) {
        transaction.setGroup("General");
        new CRUDTransactions().insert(transaction);
        mView.getActivity().showMessage("Transaction has been created");
    }

    @Override
    public void insert(Transaction transaction, int amount, int frequency) {
        new CRUDTransactions().insert(Repeated.generateTransactions(transaction, amount, frequency));
        mView.getActivity().showMessage("Transactions created");
    }
}