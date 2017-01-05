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

    private final IUpdateView<Transaction> mUpdateView;
    private final IUpdateModel<Transaction> mUpdateModel;

    public UpdateTransactionPresenter(IUpdateView<Transaction> mUpdateView) {
        this.mUpdateView = mUpdateView;
        this.mUpdateModel = new UpdateTransactionModel(this);
    }

    @Override
    public void update(Transaction Transaction) {
        mUpdateModel.update(Transaction);
    }

    @Override
    public void onUpdated() {
        mUpdateView.onObjectUpdated();
    }

    @Override
    public void onError(String message) {
        mUpdateView.onError(message);
    }
}