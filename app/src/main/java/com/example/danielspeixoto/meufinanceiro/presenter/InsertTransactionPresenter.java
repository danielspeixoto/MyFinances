package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.InsertTransaction;
import com.example.danielspeixoto.meufinanceiro.util.NoUserException;
import com.example.danielspeixoto.meufinanceiro.util.Repeated;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertTransactionPresenter implements InsertTransaction.Presenter {

    private final InsertTransaction.View mView;
    private CRUDTransactions mCRUDTransactions;

    public InsertTransactionPresenter(InsertTransaction.View mView) {
        this.mView = mView;
        try {
            mCRUDTransactions = new CRUDTransactions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Transaction transaction) {
        transaction.setGroup("General");
        mCRUDTransactions.insert(transaction);
        mView.getActivity().showMessage("Transaction has been created");
    }

    @Override
    public void insert(Transaction transaction, int amount, int frequency) {
        mCRUDTransactions.insert(Repeated.generateTransactions(transaction, amount, frequency));
        mView.getActivity().showMessage("Transactions created");
    }
}