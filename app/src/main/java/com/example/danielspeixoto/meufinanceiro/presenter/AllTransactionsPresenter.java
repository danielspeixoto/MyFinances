package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.AllTransactionsModel;
import com.example.danielspeixoto.meufinanceiro.model.module.ISelectAllModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.ISelectAllPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IListView;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllTransactionsPresenter implements ISelectAllPresenter<Transaction> {

    private IListView<Transaction> mListView;
    private ISelectAllModel<Transaction> mSelectAllModel;

    public AllTransactionsPresenter(IListView mListView) {
        this.mListView = mListView;
        this.mSelectAllModel = new AllTransactionsModel(this);
    }

    @Override
    public void selectAll() {
        mSelectAllModel.selectAll();
    }

    @Override
    public void onReceiving(Transaction transaction) {
        mListView.addItem(transaction);
    }

    @Override
    public void onError(String message) {
        mListView.onError(message);
    }
}
