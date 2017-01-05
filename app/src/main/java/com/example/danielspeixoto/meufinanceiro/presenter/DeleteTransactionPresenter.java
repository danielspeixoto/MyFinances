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

    private IDeleteView<Transaction> mDeleteView;
    private IDeleteModel<Transaction> mDeleteModel;

    public DeleteTransactionPresenter(IDeleteView mDeleteView) {
        this.mDeleteView = mDeleteView;
        this.mDeleteModel = new DeleteTransactionModel(this);
    }

    @Override
    public void delete(String id) {
        mDeleteModel.delete(id);
    }

    @Override
    public void onDeleted() {
        mDeleteView.onItemDeleted();
    }

    @Override
    public void onError(String message) {
        mDeleteView.onError(message);
    }
}
