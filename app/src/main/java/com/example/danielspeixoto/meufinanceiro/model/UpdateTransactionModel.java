package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.module.IUpdateModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IUpdatePresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class UpdateTransactionModel implements IUpdateModel<Transaction> {

    private final IUpdatePresenter<Transaction> mUpdatePresenter;
    private DatabaseReference mDatabase;

    public UpdateTransactionModel(IUpdatePresenter<Transaction> mUpdatePresenter) {
        this.mUpdatePresenter = mUpdatePresenter;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Transaction.class.getSimpleName());
    }

    @Override
    public void update(Transaction transaction) {
        mDatabase.child(transaction.getId()).setValue(transaction);
        mUpdatePresenter.onUpdated();
    }
}
