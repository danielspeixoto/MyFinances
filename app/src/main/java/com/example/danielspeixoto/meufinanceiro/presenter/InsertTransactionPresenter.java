package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.InsertTransaction;
import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.util.Repeated;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertTransactionPresenter implements InsertTransaction.Presenter {

    private final InsertTransaction.View mView;
    private CRUDTransactions mCRUD;

    public InsertTransactionPresenter(InsertTransaction.View mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDTransactions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Transaction transaction) {
        transaction.setGroup("General");
        mCRUD.insert(transaction);
        mView.getActivity().showMessage("Transaction has been created");
    }

    @Override
    public void insert(Transaction transaction, int amount, int frequency) {
        mCRUD.insert(Repeated.generateTransactions(transaction, amount, frequency));
        mView.getActivity().showMessage("Transactions created");
    }
}