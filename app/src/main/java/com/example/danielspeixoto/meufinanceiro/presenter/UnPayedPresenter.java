package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.TransactionSource;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class UnPayedPresenter implements TransactionSource.Presenter {

    private final TransactionSource.View mView;
    private CRUDTransactions mCRUD;
    public UnPayedPresenter(TransactionSource.View mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDTransactions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        mCRUD.selectAll().subscribe(new Subscriber<Transaction>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Transaction transaction) {
                    if(transaction.isPayed()) {
                        mView.addItem(transaction);
                    }
                }
            });
    }
}
