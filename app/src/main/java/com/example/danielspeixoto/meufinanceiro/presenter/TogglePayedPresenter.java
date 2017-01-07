package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.TogglePayed;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class TogglePayedPresenter implements TogglePayed.Presenter {

    private final TogglePayed.View mView;
    private CRUDTransactions mCRUD;

    public TogglePayedPresenter(TogglePayed.View mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDTransactions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toggle(Transaction transaction) {
        String message = "Your transactions is now ";
        if(transaction.isPayed()) {
            message += "paid";
        } else {
            message += "unpaid";
        }
        mView.getActivity().showMessage(message);
        transaction.setPayed(!transaction.isPayed());
        mCRUD.update(transaction);
    }
}
