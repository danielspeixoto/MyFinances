package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.view.dialog.AreYouSureDialog;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class DeleteTransactionPresenter implements CRUD.Delete.Presenter<Transaction> {

    private CRUD.Delete.View<Transaction> mView;

    public DeleteTransactionPresenter(CRUD.Delete.View mView) {
        this.mView = mView;
    }

    @Override
    public void delete(String id) {
        new AreYouSureDialog(() -> new CRUDTransactions().delete(id)).show(mView.getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
        mView.getActivity().showMessage("Transaction deleted");
        mView.getActivity().finish();
    }
}
