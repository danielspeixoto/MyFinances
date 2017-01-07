package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.module.DeleteTransaction;
import com.example.danielspeixoto.meufinanceiro.util.NoUserException;
import com.example.danielspeixoto.meufinanceiro.view.dialog.AreYouSureDialog;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class DeleteTransactionPresenter implements DeleteTransaction.Presenter {

    private DeleteTransaction.View mView;
    private CRUDTransactions mCRUDTransactions;

    public DeleteTransactionPresenter(DeleteTransaction.View mView) {
        this.mView = mView;
        try {
            mCRUDTransactions = new CRUDTransactions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        new AreYouSureDialog(() -> {
            mCRUDTransactions.delete(id);
            mView.getActivity().showMessage("All Transactions deleted");
            mView.getActivity().finish();
        }).show(mView.getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
    }

    @Override
    public void delete(String groupId, String id) {
        new AreYouSureDialog(() -> {
            mCRUDTransactions.delete(groupId, id);
            mView.getActivity().showMessage("Transaction deleted");
            mView.getActivity().finish();
        }).show(mView.getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
    }
}
