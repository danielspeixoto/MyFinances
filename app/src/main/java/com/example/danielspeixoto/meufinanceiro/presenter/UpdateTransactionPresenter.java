package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.UpdateTransactionModel;
import com.example.danielspeixoto.meufinanceiro.model.module.IUpdateModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IUpdatePresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IUpdateView;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class UpdateTransactionPresenter implements IUpdatePresenter<Transaction> {

    private final IUpdateView<Transaction> mView;
    private final IUpdateModel<Transaction> mModel;

    public UpdateTransactionPresenter(IUpdateView<Transaction> mView) {
        this.mView = mView;
        this.mModel = new UpdateTransactionModel(this);
    }

    @Override
    public void update(Transaction Transaction) {
        mModel.update(Transaction);
    }

    @Override
    public void onUpdated() {
        mView.onObjectUpdated();
    }

    @Override
    public void onError(String message) {
        mView.onError(message);
    }
}