package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.UpdateTransaction;
import com.example.danielspeixoto.meufinanceiro.util.Repeated;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class UpdateTransactionPresenter implements UpdateTransaction.Presenter<Transaction> {

    private final UpdateTransaction.View<Transaction> mView;
    CRUDTransactions mCRUDTransactions;

    public UpdateTransactionPresenter(UpdateTransaction.View<Transaction> mView) {
        this.mView = mView;
        mCRUDTransactions = new CRUDTransactions();
    }

    @Override
    public void update(Transaction Transaction) {
        mCRUDTransactions.update(Transaction);
        mView.getActivity().showMessage("Transaction updated");
        mView.getActivity().finish();
    }

    @Override
    public void update(Transaction transaction, int amount, int frequency) {
        mCRUDTransactions.delete(transaction.getGroup(), transaction.getId());
        mCRUDTransactions.insert(Repeated.generateTransactions(transaction, amount, frequency));
        mView.getActivity().showMessage("Transactions updated");
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