package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.module.IDeleteModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IDeletePresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class DeleteTransactionModel implements IDeleteModel<Transaction> {

    private final IDeletePresenter<Transaction> mDeletePresenter;
    private DatabaseReference mDatabase;

    public DeleteTransactionModel(IDeletePresenter mDeletePresenter) {
        this.mDeletePresenter = mDeletePresenter;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Transaction.class.getSimpleName());
    }

    @Override
    public void delete(String id) {
        mDatabase.child(id).removeValue();
        mDeletePresenter.onDeleted();
    }
}