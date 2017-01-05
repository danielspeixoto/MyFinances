package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.module.IInsertModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IInsertPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertTransactionModel implements IInsertModel<Transaction> {

    private final IInsertPresenter<Transaction> mInsertPresenter;
    private DatabaseReference mDatabase;

    public InsertTransactionModel(IInsertPresenter<Transaction> mInsertPresenter) {
        this.mInsertPresenter = mInsertPresenter;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Transaction.class.getSimpleName());
    }

    @Override
    public void insert(Transaction transaction) {
        transaction.setId(mDatabase.push().getKey());
        mDatabase.child(transaction.getId()).setValue(transaction);
        mInsertPresenter.onInserted();
    }
}
