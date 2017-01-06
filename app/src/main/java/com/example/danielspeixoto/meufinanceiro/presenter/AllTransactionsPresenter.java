package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllTransactionsPresenter implements CRUD.All.Presenter<Transaction> {

    private CRUD.All.View<Transaction> mView;

    public AllTransactionsPresenter(CRUD.All.View mView) {
        this.mView = mView;
    }

    @Override
    public void selectAll() {
        new CRUDTransactions().selectAll().subscribe(new Subscriber<Transaction>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Transaction transaction) {
                mView.addItem(transaction);
            }
        });
    }
}
