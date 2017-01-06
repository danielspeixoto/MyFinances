package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.AllTransactionsModel;
import com.example.danielspeixoto.meufinanceiro.model.module.ISelectAllModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IAllPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IAllView;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllTransactionsPresenter implements IAllPresenter<Transaction> {

    private IAllView<Transaction> mView;
    private ISelectAllModel<Transaction> mModel;

    public AllTransactionsPresenter(IAllView mView) {
        this.mView = mView;
        this.mModel = new AllTransactionsModel(this);
    }

    @Override
    public void selectAll() {
        mModel.selectAll();
    }

    @Override
    public void onReceiving(Transaction transaction) {
        mView.addItem(transaction);
    }

    @Override
    public void onError(String message) {
        mView.onError(message);
    }
}
