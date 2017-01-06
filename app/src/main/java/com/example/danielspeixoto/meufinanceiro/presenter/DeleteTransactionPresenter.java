package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.DeleteTransactionModel;
import com.example.danielspeixoto.meufinanceiro.model.module.IDeleteModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IDeletePresenter;
import com.example.danielspeixoto.meufinanceiro.view.dialog.AreYouSureDialog;
import com.example.danielspeixoto.meufinanceiro.view.module.IDeleteView;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class DeleteTransactionPresenter implements IDeletePresenter<Transaction> {

    private IDeleteView<Transaction> mView;
    private IDeleteModel<Transaction> mModel;

    public DeleteTransactionPresenter(IDeleteView mView) {
        this.mView = mView;
        this.mModel = new DeleteTransactionModel(this);
    }

    @Override
    public void delete(String id) {
        new AreYouSureDialog(() -> mModel.delete(id)).show(mView.getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
        mModel.delete(id);
    }

    @Override
    public void onDeleted() {
        mView.onItemDeleted();
    }

    @Override
    public void onError(String message) {
        mView.onError(message);
    }
}
