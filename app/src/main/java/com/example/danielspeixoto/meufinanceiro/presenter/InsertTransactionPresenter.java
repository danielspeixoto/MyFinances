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

    private final IInsertView<Transaction> mView;
    private final IInsertModel<Transaction> mModel;

    public InsertTransactionPresenter(IInsertView<Transaction> mView) {
        this.mView = mView;
        this.mModel = new InsertTransactionModel(this);
    }

    @Override
    public void insert(Transaction Transaction) {
        mModel.insert(Transaction);
    }

    @Override
    public void onInserted() {
        mView.onObjectInserted();
    }

    @Override
    public void onError(String message) {
        mView.onError(message);
    }
}