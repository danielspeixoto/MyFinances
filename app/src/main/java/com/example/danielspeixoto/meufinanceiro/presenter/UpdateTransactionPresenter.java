package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.UpdateTransaction;
import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.util.Repeated;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class UpdateTransactionPresenter implements UpdateTransaction.Presenter<Transaction> {

    private final UpdateTransaction.View<Transaction> mView;
    private CRUDTransactions mCRUD;
    private CRUDInstitutions mCRUDInstitutions;

    public UpdateTransactionPresenter(UpdateTransaction.View<Transaction> mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDTransactions();
            mCRUDInstitutions = new CRUDInstitutions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Transaction Transaction) {
        mCRUD.update(Transaction);
        mView.getActivity().showMessage("Transaction updated");
        mView.getActivity().finish();
    }

    @Override
    public void update(Transaction transaction, int amount, int frequency) {
        mCRUD.delete(transaction);
        mCRUD.insert(Repeated.generateTransactions(transaction, amount, frequency));
        mView.getActivity().showMessage("Transactions updated");
    }

    @Override
    public void selectInstitutions(String id) {
        mCRUDInstitutions.selectAll().subscribe(new Subscriber<Institution>() {
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