package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.InsertTransactionModel;
import com.example.danielspeixoto.meufinanceiro.model.module.IInsertModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IInsertPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IInsertView;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertTransactionPresenter implements IInsertPresenter<Transaction> {

    private final IInsertView<Transaction> mInsertView;
    private final IInsertModel<Transaction> mInsertModel;
    private Transaction mTransaction;

    public InsertTransactionPresenter(IInsertView<Transaction> mInsertView) {
        this.mInsertView = mInsertView;
        this.mInsertModel = new InsertTransactionModel(this);
    }

    @Override
    public void insert(Transaction Transaction) {
        mTransaction = Transaction;
        mInsertModel.insert(Transaction);
    }

    @Override
    public void onInserted() {
        mInsertView.onObjectInserted();
    }

    @Override
    public void onError(String message) {
        mInsertView.onError(message);
    }
}