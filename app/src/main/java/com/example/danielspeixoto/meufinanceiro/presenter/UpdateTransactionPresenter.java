package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.UpdateTransaction;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class UpdateTransactionPresenter implements UpdateTransaction.Presenter<Transaction> {

    private final UpdateTransaction.View<Transaction> mView;

    public UpdateTransactionPresenter(UpdateTransaction.View<Transaction> mView) {
        this.mView = mView;
    }

    @Override
    public void update(Transaction Transaction) {
        new CRUDTransactions().update(Transaction);
        mView.getActivity().showMessage("Transaction updated");
        mView.getActivity().finish();
    }

    @Override
    public void selectInstitutions(String id) {
        new CRUDInstitutions().selectAll().subscribe(new Subscriber<Institution>() {
            int counter = 0;

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Institution institution) {
                mView.addItem(institution);
                if(institution.getId().equals(id)) {
                    mView.setRelatedItemIndex(counter);
                }
                counter++;
            }
        });
    }
}